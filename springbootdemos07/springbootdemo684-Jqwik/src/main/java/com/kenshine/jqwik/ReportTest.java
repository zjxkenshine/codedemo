package com.kenshine.jqwik;

import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Reporter;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.footnotes.EnableFootnotes;
import net.jqwik.api.footnotes.Footnotes;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;

/**
 * @author by kenshine
 * @Classname ReportTest
 * @Description 输出报告
 * @Date 2024-01-18 9:33
 * @modified By：
 * @version: 1.0$
 */
public class ReportTest {
    /**
     * 使用@Example标记简单的、基于示例的测试用例方法,只被执行一次
     */
    @Example
    public void reportInCode(Reporter reporter, @ForAll List<@AlphaChars String> aList) {
        reporter.publishReport("listOfStrings", aList);
        reporter.publishValue("birthday", LocalDate.of(1969, 1, 20).toString());
    }
}
