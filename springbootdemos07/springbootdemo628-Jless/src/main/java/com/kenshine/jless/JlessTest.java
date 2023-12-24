package com.kenshine.jless;

import com.bazaarvoice.jless.LessProcessor;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/24 14:31
 * @description：使用测试
 * @modified By：
 * @version: $
 */
public class JlessTest {

    /**
     * 解析less
     */
    @Test
    public void test() throws IOException {
        LessProcessor processor = new LessProcessor();
        processor.setCompressionEnabled(false);
        processor.setTranslationEnabled(false);
        String css = processor.process(new FileInputStream("src\\main\\resources\\test01.less")).toString();
        System.out.println(css);
    }
}
