package com.kenshine.ektorp.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/17 9:59
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Data
public class CouchDBInfo {
    @Value(value = "${couchdb.host}")
    private String host;
    @Value(value = "${couchdb.port}")
    private String port;
    @Value(value = "${couchdb.database}")
    private String database;
    @Value(value = "${couchdb.username}")
    private String username;
    @Value(value = "${couchdb.password}")
    private String password;
}
