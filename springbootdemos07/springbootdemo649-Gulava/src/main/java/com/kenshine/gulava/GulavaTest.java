package com.kenshine.gulava;

import com.kenshine.gulava.model.Cons;
import gulava.*;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author by kenshine
 * @Classname GulavaTest
 * @Description Gulava关系编程库使用测试
 * @Date 2024-01-04 13:36
 * @modified By：
 * @version: 1.0$
 */
public class GulavaTest {

    @Test
    public void test01(){
        // ab间的关系
        Cons<String, String> list = Cons.of("foo", "bar");
        System.out.println(list);
    }

    /**
     * 官方示例
     */
    @Test
    public void test02() throws IOException {
        Var a = new Var();
        Var b = new Var();
        System.out.println("\nTry append");
        Goal append = Cons.goals.append(a, b, Cons.s(1, 2, 3, 4, 5, 6, 7));
        print(append.run(Subst.EMPTY), 1000, false, a, b);
    }


    static void print(Stream s, int maxSteps, boolean dump, Var... requestedVars) throws IOException {
        Dumper dumper = new Dumper(0, new OutputStreamWriter(System.out));
        int totalSteps = 0;
        while (totalSteps < maxSteps) {
            if (s == Streams.EMPTY) {
                System.out.println("()");
                break;
            }
            if (dump) {
                System.out.println("\n--------------------------------------------------------------------------------");
                dumper.dump(s);
                dumper.flush();
            }
            Subst subst = s.subst();

            if (subst != null) {
                System.out.println(new View.Builder()
                        .setSubst(subst)
                        .addRequestedVar(requestedVars)
                        .build());
            }
            s = s.rest();
            totalSteps++;
        }
        System.out.println("total steps: " + totalSteps);
    }
}
