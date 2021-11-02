package com.kenshine.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:26
 * @description：示例service
 * @modified By：
 * @version: $
 */
@WebService(name = "demo", targetNamespace = "http://webservices.cxf.test.zqw.com")
public interface DemoService {
    @WebMethod
    String myTest();

    @WebMethod
    String get(@WebParam(name = "id") String id);
}
