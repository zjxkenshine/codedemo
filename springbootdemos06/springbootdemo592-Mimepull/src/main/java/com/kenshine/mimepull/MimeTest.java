package com.kenshine.mimepull;

import org.junit.Test;
import org.jvnet.mimepull.MIMEConfig;
import org.jvnet.mimepull.MIMEMessage;
import org.jvnet.mimepull.MIMEPart;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author by kenshine
 * @Classname MimeTest
 * @Description Mimepull使用测试
 * @Date 2023-12-16 11:17
 * @modified By：
 * @version: 1.0$
 */
public class MimeTest {
    private static final String BOUNDARY = "boundary";
    private static final int PART_SIZE = 4 * 8192;
    private static final String PATH ="mime\\";

    /**
     * MIMEPart moveTo 保存到文件
     */
    @Test
    public void test01() throws IOException {
        final MIMEConfig config = new MIMEConfig();
        // 最大内存
        config.setMemoryThreshold(4096);
        /**
         * in–MIME消息流
         * BOUNDARY–分隔符 这里是--boundary
         * config–各种配置参数
         */
        final MIMEMessage message = new MIMEMessage(getInputStream(PART_SIZE), BOUNDARY, config);
        final MIMEPart part = message.getAttachments().get(0);
        // 创建临时文件
        final File tempFile = File.createTempFile("ship", "it");
        tempFile.deleteOnExit();
        // 移动到文件
        part.moveTo(tempFile);
        System.out.println(tempFile.getAbsolutePath());
    }

    /**
     * 解析MIME
     */
    @Test
    public void test02() throws IOException {
        InputStream in = new FileInputStream(PATH + "test01.txt");
        // --+分隔符
        String boundary = "----=_kenshine";
        // 终止符 ------=_kenshine--，后面要加--
        MIMEConfig config = new MIMEConfig();
        MIMEMessage mm = new MIMEMessage(in, boundary , config);
        mm.parseAll();
        List<MIMEPart> parts = mm.getAttachments();
        {
            byte[] buf = new byte[8192];
            InputStream part0 = parts.get(0).read();
            int len = part0.read(buf, 0, buf.length);
            String str = new  String(buf, 0, len);
            System.out.println(str);
            part0.close();
        }
        {
            InputStream part1 = parts.get(1).read();
            part1.close();
        }
    }


    private InputStream getInputStream(final int size) {
        final byte[] data = (
                "--boundary\r\n"+
                        "Content-Type: text/plain\r\n"+
                        "Content-Id: partA\r\n\r\n"+
                        "1\r\n"+
                        "--boundary\r\n"+
                        "Content-Type: text/plain\r\n"+
                        "Content-ID: partB\r\n\r\n"+
                        "2\r\n"+
                        "--boundary\r\n"+
                        "Content-Type: text/plain\r\n"+
                        "Content-ID: partC\r\n\r\n"+
                        "3\r\n"+
                        "--boundary--").getBytes();

        return new InputStream() {
            int i, j;

            @Override
            public int read() throws IOException {
                if (i >= data.length) {
                    return -1;
                } else if (data[i] == '1' || data[i] == '2' || data[i] == '3') {
                    if (j < size) {
                        int partNo = data[i] - '1';
                        return (byte) ('A' + (partNo + j++) % 26);
                    } else {
                        j = 0;
                        i++;
                    }
                }
                return data[i++];
            }
        };
    }
}
