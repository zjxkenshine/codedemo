package com.kenshine.protoparser;

import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoParser;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ProtoparserTest
 * @Description Protoparser解析测试
 * @Date 2024-04-06 9:28
 * @modified By：
 * @version: 1.0$
 */
public class ProtoparserTest {

    /**
     * Protoparser 解析.proto文件
     */
    @Test
    public void test01(){
        String proto = ""
                + "message Types {\n"
                + "  required any f1 = 1;\n"
                + "  required bool f2 = 2;\n"
                + "  required bytes f3 = 3;\n"
                + "  required double f4 = 4;\n"
                + "  required float f5 = 5;\n"
                + "  required fixed32 f6 = 6;\n"
                + "  required fixed64 f7 = 7;\n"
                + "  required int32 f8 = 8;\n"
                + "  required int64 f9 = 9;\n"
                + "  required sfixed32 f10 = 10;\n"
                + "  required sfixed64 f11 = 11;\n"
                + "  required sint32 f12 = 12;\n"
                + "  required sint64 f13 = 13;\n"
                + "  required string f14 = 14;\n"
                + "  required uint32 f15 = 15;\n"
                + "  required uint64 f16 = 16;\n"
                + "  required map<string, bool> f17 = 17;\n"
                + "  required map<arbitrary, nested.nested> f18 = 18;\n"
                + "  required arbitrary f19 = 19;\n"
                + "  required nested.nested f20 = 20;\n"
                + "}\n";
        ProtoFile protoFile=ProtoParser.parse("test.proto", proto);
        System.out.println(protoFile);
    }
}
