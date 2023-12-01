package com.kenshine.exchangecore;

import exchange.core2.core.ExchangeApi;
import exchange.core2.core.ExchangeCore;
import exchange.core2.core.IEventsHandler;
import exchange.core2.core.SimpleEventsProcessor;
import exchange.core2.core.common.*;
import exchange.core2.core.common.api.*;
import exchange.core2.core.common.api.binary.BatchAddSymbolsCommand;
import exchange.core2.core.common.api.reports.SingleUserReportQuery;
import exchange.core2.core.common.api.reports.SingleUserReportResult;
import exchange.core2.core.common.api.reports.TotalCurrencyBalanceReportQuery;
import exchange.core2.core.common.api.reports.TotalCurrencyBalanceReportResult;
import exchange.core2.core.common.cmd.CommandResultCode;
import exchange.core2.core.common.config.ExchangeConfiguration;
import exchange.core2.core.processors.journaling.DummySerializationProcessor;
import exchange.core2.core.processors.journaling.ISerializationProcessor;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author by kenshine
 * @Classname ExchangeTest
 * @Description 使用测试
 * @Date 2023-12-01 19:31
 * @modified By：
 * @version: 1.0$
 */
public class ExchangeTest {

    private static ExchangeApi api;

    @BeforeClass
    public static void before(){
        /**
         * 初始化ExchangeApi
         */
        // 简单的异步事件处理器
        SimpleEventsProcessor eventsProcessor = new SimpleEventsProcessor(new IEventsHandler() {
            @Override
            public void tradeEvent(TradeEvent tradeEvent) {
                System.out.println("Trade event: " + tradeEvent);
            }

            @Override
            public void reduceEvent(ReduceEvent reduceEvent) {
                System.out.println("Reduce event: " + reduceEvent);
            }

            @Override
            public void rejectEvent(RejectEvent rejectEvent) {
                System.out.println("Reject event: " + rejectEvent);
            }

            @Override
            public void commandResult(ApiCommandResult commandResult) {
                System.out.println("Command result: " + commandResult);
            }

            @Override
            public void orderBook(OrderBook orderBook) {
                System.out.println("OrderBook event: " + orderBook);
            }
        });

        // 默认比较配置
        ExchangeConfiguration conf = ExchangeConfiguration.defaultBuilder().build();

        // no serialization
        //Supplier<ISerializationProcessor> serializationProcessorFactory = () -> DummySerializationProcessor.INSTANCE;

        // 构建ExchangeCore
        ExchangeCore exchangeCore = ExchangeCore.builder()
                .resultsConsumer(eventsProcessor)
                .exchangeConfiguration(conf)
                .build();

        // 开启disruptor线程
        exchangeCore.startup();

        // 获取用于发布命令的api
        api= exchangeCore.getApi();
    }

    /**
     * 货币交易示例
     */
    @Test
    public void test01() throws ExecutionException, InterruptedException {
        // 货币代码常量
        final int currencyCodeXbt = 11;
        final int currencyCodeLtc = 15;

        // 符号常量
        final int symbolXbtLtc = 241;

        // 创建符号规范并提交
        CoreSymbolSpecification symbolSpecXbtLtc = CoreSymbolSpecification.builder()
                .symbolId(symbolXbtLtc)         // symbol id
                .type(SymbolType.CURRENCY_EXCHANGE_PAIR)
                .baseCurrency(currencyCodeXbt)    // base = satoshi (1E-8)
                .quoteCurrency(currencyCodeLtc)   // quote = litoshi (1E-8)
                .baseScaleK(1_000_000L) // 1 lot = 1M satoshi (0.01 BTC)
                .quoteScaleK(10_000L)   // 1 price step = 10K litoshi
                .takerFee(1900L)        // taker fee 1900 litoshi per 1 lot
                .makerFee(700L)         // maker fee 700 litoshi per 1 lot
                .build();

        CompletableFuture<CommandResultCode> future = api.submitBinaryDataAsync(new BatchAddSymbolsCommand(symbolSpecXbtLtc));

        // 创建用户
        future = api.submitCommandAsync(ApiAddUser.builder()
                .uid(301L)
                .build());

        // 创建用户
        future = api.submitCommandAsync(ApiAddUser.builder()
                .uid(302L)
                .build());

        // 执行存款
        // 第一个用户存入20 LTC
        future = api.submitCommandAsync(ApiAdjustUserBalance.builder()
                .uid(301L)
                .currency(currencyCodeLtc)
                .amount(2_000_000_000L)
                .transactionId(1L)
                .build());

        // 第二个用户存入0.10 BTC
        future = api.submitCommandAsync(ApiAdjustUserBalance.builder()
                .uid(302L)
                .currency(currencyCodeXbt)
                .amount(10_000_000L)
                .transactionId(2L)
                .build());

        // 假设BTCLTC的汇率是154 LTC兑换1 BTC
        // 1手(0.01BTC)的买入价为1.54 LTC => 1 5400 000 litoshi => 10K * 15 400(价格步长)
        future = api.submitCommandAsync(ApiPlaceOrder.builder()
                .uid(301L)
                .orderId(5001L)
                .price(15_400L)
                .reservePrice(15_600L) // can move bid order up to the 1.56 LTC, without replacing it
                .size(12L) // order size is 12 lots
                .action(OrderAction.BID)
                .orderType(OrderType.GTC) // Good-till-Cancel
                .symbol(symbolXbtLtc)
                .build());

        // 第二个用户下立即或取消询问(卖出)订单
        // 他假设以最优惠的价格卖出152.5 LTC换取1 BTC
        future = api.submitCommandAsync(ApiPlaceOrder.builder()
                .uid(302L)
                .orderId(5002L)
                .price(15_250L)
                .size(10L) // order size is 10 lots
                .action(OrderAction.ASK)
                .orderType(OrderType.IOC) // Immediate-or-Cancel
                .symbol(symbolXbtLtc)
                .build());

        // 申请订单
        CompletableFuture<L2MarketData> future1 = api.requestOrderBookAsync(symbolXbtLtc, 10);

        // 第一个用户将剩余订单移动到价格1.53 LTC
        future = api.submitCommandAsync(ApiMoveOrder.builder()
                .uid(301L)
                .orderId(5001L)
                .newPrice(15_300L)
                .symbol(symbolXbtLtc)
                .build());

        // 第一个用户取消剩余订单
        future = api.submitCommandAsync(ApiCancelOrder.builder()
                .uid(301L)
                .orderId(5001L)
                .symbol(symbolXbtLtc)
                .build());

        // 检查用户余额和GtC订单
        Future<SingleUserReportResult> report = api.processReport(new SingleUserReportQuery(301), 0);
        System.out.println(report);

        // 检查系统平衡
        Future<TotalCurrencyBalanceReportResult> totalsReport = api.processReport(new TotalCurrencyBalanceReportQuery(), 0);
        System.out.println("LTC fees collected: " + totalsReport.get().getFees().get(currencyCodeLtc));
    }
}
