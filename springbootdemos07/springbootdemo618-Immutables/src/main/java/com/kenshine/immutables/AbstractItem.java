package com.kenshine.immutables;

import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

@Value.Immutable
abstract class AbstractItem {
  abstract String getName();
  abstract Set<String> getTags();
  abstract Optional<String> getDescription();
}