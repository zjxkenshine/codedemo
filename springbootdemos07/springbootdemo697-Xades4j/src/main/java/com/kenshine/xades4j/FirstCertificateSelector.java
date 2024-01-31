package com.kenshine.xades4j;

import xades4j.providers.impl.KeyStoreKeyingDataProvider;

import java.util.List;

/**
 * @author kenshine
 */
public class FirstCertificateSelector implements KeyStoreKeyingDataProvider.SigningCertificateSelector {

    @Override
    public Entry selectCertificate(List<Entry> list) {
        return list.get(0);
    }
}
