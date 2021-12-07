package com.kenshine.javolution.struct;

import javolution.io.Struct;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 17:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Date extends Struct {
     public final Unsigned16 year = new Unsigned16();
     public final Unsigned8 month = new Unsigned8();
     public final Unsigned8 day   = new Unsigned8();
}
