package com.kenshine.immutables;

import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

/**
 * @author kenshine
 * 不可变接口
 */
@Value.Immutable
public interface ValueObject {
  String name();
  List<Integer> counts();
  Optional<String> description();
}