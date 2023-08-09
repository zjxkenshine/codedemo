package com.kenshine.vault;

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 测试
 * @Date 2023-08-09 9:45
 * @modified By：
 * @version: 1.0$
 */
public class Test {
    public static void main(String[] args) {
        URI uri = URI.create("http://127.0.0.1:8200");
        VaultTemplate vaultTemplate = new VaultTemplate(VaultEndpoint.from(uri),
                new TokenAuthentication("hvs.SPZ9klezjV9jurWmIqo6J0gf"));

        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        vaultTemplate.write("kvdemo/myapp", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("kvdemo/myapp", Secrets.class);
        System.out.println(response.getData().getUsername());

        vaultTemplate.delete("kvdemo/myapp");
    }
}
