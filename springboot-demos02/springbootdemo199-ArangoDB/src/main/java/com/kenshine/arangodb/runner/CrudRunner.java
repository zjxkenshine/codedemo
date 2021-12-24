package com.kenshine.arangodb.runner;

import com.arangodb.springframework.core.ArangoOperations;
import com.kenshine.arangodb.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 22:35
 * @description： 官方demo中用来crud的，搬到Controller了
 * @modified By：
 * @version: $
 */
@ComponentScan("com.kenshine.arangodb")
public class CrudRunner implements CommandLineRunner {
    @Autowired
    private ArangoOperations operations;
    @Autowired
    private CharacterRepository repository;

    @Override
    public void run(final String... args) throws Exception {
    }
}
