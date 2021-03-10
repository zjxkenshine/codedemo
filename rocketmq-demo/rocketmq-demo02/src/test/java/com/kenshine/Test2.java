package com.kenshine;

import com.kenshine.demo02.Producer02;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Scanner;

@SpringBootTest
public class Test2 {
    @Autowired
    private Producer02 p;

    @Test
    public void test() {
        p.send();

        System.out.println("按回车结束");
        new Scanner(System.in).nextLine();
    }
}