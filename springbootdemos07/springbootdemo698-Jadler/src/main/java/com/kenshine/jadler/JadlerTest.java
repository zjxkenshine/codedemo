package com.kenshine.jadler;

import com.kenshine.jadler.service.AccountService;
import com.kenshine.jadler.service.AccountServiceRestImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.jadler.Jadler.*;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

/**
 * @author by kenshine
 * @Classname JadlerTest
 * @Description jadler使用示例
 * @Date 2024-02-01 8:45
 * @modified By：
 * @version: 1.0$
 */
public class JadlerTest {
    @Before
    public void setUp() {
        initJadler();
    }

    @After
    public void tearDown() {
        closeJadler();
    }

    @Test
    public void getAccount() {
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo("/accounts/1")
                .havingBody(isEmptyOrNullString())
                .havingHeaderEqualTo("Accept", "application/json")
                // 返回值模拟
                .respond()
                .withDelay(2, SECONDS)
                .withStatus(200)
                .withBody("{\"account\":{\"id\" : 1}}")
                .withEncoding(StandardCharsets.UTF_8)
                .withContentType("application/json; charset=UTF-8");

        final AccountService service = new AccountServiceRestImpl("http", "localhost", port());
        final Account account = service.getAccount(1);
        System.out.println(account);
    }

    @Test
    public void getAccountNotFound() {
        onRequest()
                .havingMethodEqualTo("GET")
                .havingPathEqualTo("/accounts/" + 1)
                .respond()
                .withStatus(404);

        final AccountService am = new AccountServiceRestImpl("http", "localhost", port());
        Account account = am.getAccount(1);
        System.out.println(account);
    }


    @Test
    public void deleteAccount() {
        onRequest()
                .havingMethodEqualTo("DELETE")
                .havingPathEqualTo("/accounts/1")
                .respond()
                .withStatus(204);
        final AccountService service = new AccountServiceRestImpl("http", "localhost", port());
        service.deleteAccount(1);
        verifyThatRequest()
                .havingMethodEqualTo("DELETE")
                .havingPathEqualTo("/accounts/1")
                .receivedOnce();
    }
}
