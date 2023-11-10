package com.kenshine.markdowntoc;

import com.github.houbb.markdown.toc.util.MdTocTextHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/10 21:41
 * @description：md字符串
 * @modified By：
 * @version: $
 */
public class StringTest {

    @Test
    public void test01(){
        List<String> lines = new ArrayList<>();
        lines.add("# 标题1");
        lines.add("这是一行内容");
        lines.add("# 标题2");
        lines.add("这也是一行内容");
        List<String> tocList = MdTocTextHelper.getTocList(lines);
        System.out.println(tocList);
        // 指定编号
        List<String> tocList1 = MdTocTextHelper.getTocList(lines, true);
        System.out.println(tocList1);
    }



}
