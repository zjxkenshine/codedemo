package com.keshine.autovalue;

import com.google.auto.value.AutoValue;

/**
 * 要生成的类
 * 编译后会生成AutoValue_User
 */
@AutoValue
abstract public class User {
  static User create(String name, int age, String address){
    return new AutoValue_User(name, age, address);
  }
  abstract public String name();
  abstract public int age();
  abstract public String address();
}