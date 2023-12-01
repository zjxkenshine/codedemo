package com.kenshine.jflex.complex;

import java.io.File;

/**
 * @author by kenshine
 * @Classname test02
 * @Description 复杂解析
 * @Date 2023-12-01 16:12
 * @modified By：
 * @version: 1.0$
 */
public class test02 {
    public static void main(String[] args) {
        try {
            String dirName = "springbootdemo519-JFlex\\src\\main\\java\\com\\kenshine\\jflex\\complex";

            File file = new File( dirName, "program.in" );

            MyParser p = new MyParser( file );
            // p.parse();
            p.debug_parse();
        }
        catch ( Exception e ) {
            System.err.println( "Exception at " );
            e.printStackTrace();
        }
    }
}
