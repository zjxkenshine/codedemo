package com.kenshine.qdox.demo08;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo08 {

    /**
     * This method does nothing at all.
     *
     * @returns A boolean of whether we care or not.
     * @param email Someone's email address.
     * @param dob Date of birth.
     *
     * @permission administrator full-access
     * @webservice publish=true name=myservice type=rpc
     */
    boolean doWeCare(String email, Date dob){return true;}
}
