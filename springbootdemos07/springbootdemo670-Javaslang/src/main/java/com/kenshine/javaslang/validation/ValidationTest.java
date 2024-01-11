package com.kenshine.javaslang.validation;

import javaslang.collection.List;
import javaslang.control.Validation;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname ValidationTest
 * @Description 校验
 * @Date 2024-01-11 10:38
 * @modified By：
 * @version: 1.0$
 */
public class ValidationTest {

    /**
     * 使用Validation进行校验
     */
    @Test
    public void test01(){
        PersonValidator personValidator = new PersonValidator();
        Validation<List<String>, Person> valid =
                personValidator.validatePerson("kenshine", 30);
        Validation<List<String>, Person> invalid =
                personValidator.validatePerson("John? Doe!4", -1);
        assertEquals(
                "Valid(Person(name=kenshine, age=30))",
                valid.toString()
        );
        assertEquals(
                "Invalid(List(Invalid characters in name: ?!4, Age must be at least 0))",
                invalid.toString()
        );
    }
}
