package com.kenshine.fanuc.config;

public class Configured implements Configurable {
  private Configuration configuration;

  public Configured(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public void setConf(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public Configuration getConf() {
    return configuration;
  }
}
