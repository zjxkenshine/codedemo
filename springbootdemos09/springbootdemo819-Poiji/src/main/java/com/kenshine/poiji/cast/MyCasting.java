package com.kenshine.poiji.cast;

import com.poiji.config.Casting;
import com.poiji.option.PoijiOptions;

import java.lang.reflect.Field;

/**
 * @author 自定义cast
 */
public class MyCasting implements Casting {

    @Override
    public Object castValue(Field field, String s, int i, int i1, PoijiOptions poijiOptions) {
        System.out.println(s);
        System.out.println(i);
        System.out.println(i1);
        return s.trim();
    }
}