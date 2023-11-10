package com.kenshine.junitperf.report;

import com.github.houbb.junitperf.core.report.Reporter;
import com.github.houbb.junitperf.model.evaluation.EvaluationContext;

import java.util.Collection;

public class MyReporter implements Reporter {
    @Override
    public void report(Class testClass, Collection<EvaluationContext> evaluationContextSet) {
        System.out.println("MyReporter");
    }
}