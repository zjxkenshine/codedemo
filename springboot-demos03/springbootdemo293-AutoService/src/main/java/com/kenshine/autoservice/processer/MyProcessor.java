package com.kenshine.autoservice.processer;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 8:16
 * @description：
 * @modified By：
 * @version: $
 */
@AutoService(value = {Processor.class})
public class MyProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        System.out.println("MyProcessor------------init---------------");
        super.init(processingEnv);
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("MyProcessor------------process---------------");
        return false;
    }
}
