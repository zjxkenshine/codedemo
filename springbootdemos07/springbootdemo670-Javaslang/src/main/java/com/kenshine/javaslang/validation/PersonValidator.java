package com.kenshine.javaslang.validation;

import javaslang.Function2;
import javaslang.collection.List;
import javaslang.control.Validation;

/**
 * @author by kenshine
 * @Classname PersonValidator
 * @Description 校验
 * @Date 2024-01-11 10:33
 * @modified By：
 * @version: 1.0$
 */
public class PersonValidator {
    String NAME_ERR = "Invalid characters in name: ";
    String AGE_ERR = "Age must be at least 0";

    public Validation<List<String>, Person> validatePerson(String name, int age) {
        return Validation.combine(validateName(name), validateAge(age)).ap((Function2<String, Integer, Person>) Person::new);
    }

    private Validation<String, String> validateName(String name) {
        String invalidChars = name.replaceAll("[a-zA-Z ]", "");
        return invalidChars.isEmpty() ?
                Validation.valid(name)  : Validation.invalid(NAME_ERR + invalidChars);
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < 0 ? Validation.invalid(AGE_ERR)  : Validation.valid(age);
    }
}
