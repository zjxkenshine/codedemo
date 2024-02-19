package com.kenshine.flogger;

import com.cyfonly.flogger.FLogger;
import com.cyfonly.flogger.constants.Constant;

/**
 * @author by kenshine
 * @Classname FloggerMain
 * @Description 使用测试
 * @Date 2024-02-19 15:17
 * @modified By：
 * @version: 1.0$
 */
public class FloggerMain {
    public static void main(String[] args) {
        //获取单例
        FLogger logger = FLogger.getInstance();
        //简便api,只需指定内容
        logger.info("日志内容...");
        //指定日志级别和内容，文件名自动映射
        logger.writeLog(Constant.INFO, "自定义日志级别...");
        //指定日志输出文件名、日志级别和内容
        logger.writeLog("error", Constant.ERROR, "自定义日志文件以及级别...");
    }
}
