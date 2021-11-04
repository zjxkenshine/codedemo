package com.kenshine.csv.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 10:35
 * @description：Csv业务
 * @modified By：
 * @version: $
 */
@Service
public class CsvService {
    public String[] getHead() {
        return new String[]{"表头1","表头2"};
    }

    public List<String[]> getValues() {
        ArrayList<String[]> values = new ArrayList<>();
        values.add(new String[]{"值1","值2"});
        return values;
    }

    public String getName() {
        return "这是测试的csv";
    }

    public void doSth(List<List<String>> list) {
        System.out.println(list);
    }
}
