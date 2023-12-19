package com.kenshine.specsy.other;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.core.Closure;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;

import static com.kenshine.specsy.other.AcceptanceTestHelpers.pendingUntilFixed;

/**
 * @author Kenshine
 * 挂起直到修复
 */
public class PendingUntilFixedExampleSpec extends JavaSpecsy {
    @Override
    public void run() {
        spec("已实现功能的验收测试", () -> {
        });
 
        spec("功能尚未实现的验收测试", () -> pendingUntilFixed(() -> {
            throw new AssertionError("this feature is not implemented");
        }));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                .setTestClasses(PendingUntilFixedExampleSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}

class AcceptanceTestHelpers {
    public static void pendingUntilFixed(Closure closure) {
        try {
            closure.run();
        } catch (Throwable t) {
            // 挂起直到修复
            System.err.println("This test is pending until fixed:");
            t.printStackTrace();
            return;
        }
        throw new AssertionError("此测试现在将通过。请删除“pendingUntilFixed”标记");
    }
}
