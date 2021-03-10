package com.kenshine;

import com.kenshine.demo01.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
public class Test1 {
    @Autowired
    private Producer p;

    @Test
    public void test() {
        p.send();
    }
}
