package com.kenshine.vault.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

/**
 * @author by kenshine
 * @Classname AppConfig
 * @Description 配置
 * @Date 2023-08-09 11:12
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class AppConfig extends AbstractVaultConfiguration {
    /**
     * Specify an endpoint for connecting to Vault.
     */
    @Override
    public VaultEndpoint vaultEndpoint() {
        VaultEndpoint vaultEndpoint = new VaultEndpoint();
        vaultEndpoint.setScheme("http");//默认是HTTPS url默认是localhost
        vaultEndpoint.setPort(8200);
        return vaultEndpoint;
    }

    /**
     * Configure a client authentication.
     * Please consider a more secure authentication method
     * for production use.
     */
    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication("hvs.SPZ9klezjV9jurWmIqo6J0gf");//vault提供的token
    }

}
