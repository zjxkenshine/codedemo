package com.keshine.autovalue;

import com.google.auto.value.AutoValue;

/**
 * builder模式生成
 */
@AutoValue
abstract class User2{
  abstract public String name();
  abstract public int age();
  abstract public String address();

  static Builder builder() {
    return new AutoValue_User2.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setName(String name);
    abstract Builder setAge(int age);
    abstract Builder setAddress(String address);
    abstract User2 build();
  }
}