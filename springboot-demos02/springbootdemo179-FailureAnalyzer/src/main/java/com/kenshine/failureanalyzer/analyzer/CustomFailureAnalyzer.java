package com.kenshine.failureanalyzer.analyzer;

import com.kenshine.failureanalyzer.exception.CustomException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 12:25
 * @description：自定义失败分析器
 * @modified By：
 * @version: $
 */
public class CustomFailureAnalyzer extends AbstractFailureAnalyzer<CustomException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, CustomException cause) {
        return new FailureAnalysis("出现了自定义异常！！！", "快去检查一下吧", cause);
    }
}
