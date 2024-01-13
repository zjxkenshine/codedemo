package com.kenshine.symbolsolver.comment;

/**
  * @author kenshine
  * 我是 Javadoc 注释
 *
 *  注释类型：
 *  JavadocComment
 *  LineComment
 *  BlockComment
  */
 public class Input {
     /**
      * 我是 Javadoc 注释
      *
      * @param param1
      * @param param2
      */
     public static void someMethod(String param1, // 我是单行注释
                                   String param2
 // 我是单行注释 String param3,
 /* 我是块注释 String param4,
                                   String param5,
                                   String param6 */
         /* 我是块注释 String param4 */)
  {
         // 我是单行注释
         int a = 1;
         /* 我是块注释，注意我和Javadoc注释的区别，我只有一个星号 */
         int b = 2;
         /*
          * 我是块注释
          */
         int c = 3;
         String s1 = "// 我是字符串中的内容，不是注释";
         String s2 = "/* 我是字符串中的内容，不是注释 */";
         String s3 = "/** 我是字符串中的内容，不是注释 */";
     }
 }