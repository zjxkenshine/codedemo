package com.kenshine.compiletest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname MyProcessor
 * @Description 自定义编译期注解处理器
 * @Date 2024-01-06 11:02
 * @modified By：
 * @version: 1.0$
 */
@SupportedAnnotationTypes("com.kenshine.compiletest.AAA")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {
    public MyProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 包含AAA注解 进行处理
        for(Element elem : roundEnv.getElementsAnnotatedWith(AAA.class)) {
            Method method = Method.from((ExecutableElement)elem);
            if(!method.matchesTypes(String.class, StringBuilder.class)) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "No! " + elem + " has the wrong args!");
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Yey " + elem + " this is fine!");
            }
        }
        return true;
    }
}
