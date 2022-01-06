package com.kenshine.io.Test05_Filter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 10:23
 * @description：过滤字符流测试
 * @modified By：
 * @version: $
 * FilterReader类是个用于过滤读取字符流的抽象类
 *
 * 字符过滤输出流、与FilterOutputStream功能一样、只是简单重写了父类的方法、目的是为所有装饰类提供标准和基本的方法、要求子类必须实现核心方法、和拥有自己的特色。
 * 这里FilterWriter没有子类、可能其意义只是提供一个接口、留着以后的扩展
 *
 * 有很多具有特殊功能的类都是FilterInputStream和FilterOutputStream这两个类中的子类
 * 在字符流中他们的设计却不是作为Filterxxx的子类来实现、而是直接作为Writer、Reader的子类出现
 */
public class FilterReaderWriterTest {
    /**
     *  int read()                             //读取一个字节
     *  int read(char[] b, int off, int len)	//批量写入字符,自定义起始和长度
     *  long skip(long n)                      //跳过n个字符数
     *  boolean ready()                        //判断此流是否可以读取
     *  boolean markSupport()                  //判断流是否支持标记操作
     *  void mark()                            //标记流
     *  void reset()	                        //重置最后一次mark的位置
     *  void close()                           //关闭流
     */

}
