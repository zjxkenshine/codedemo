package com.kenshine.spirepdf;

import com.spire.pdf.conversion.PdfGrayConverter;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description PDF 转灰度
 * @Date 2024-02-26 8:55
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {

    @Test
    public void test01(){
        //创建一个PdfGrayConverter实例并加载PDF文档
        PdfGrayConverter converter = new PdfGrayConverter("pdf//Test01.pdf");

        //将彩色PDF转换为灰度
        converter.toGrayPdf("pdf//ToGray.pdf");
        converter.dispose();
    }

}
