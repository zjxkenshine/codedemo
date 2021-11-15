package com.kenshine.graphql.entity.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ResponseBuilder {

    public static final Logger logger = LogManager.getLogger(ResponseBuilder.class);

    private ResponseBuilder() {
    }

    public static Result getRespCode(int errCode) {
        Result result = new Result();
        result.setRespCode(errCode);
        return result;
    }

    public static Result getRespCodeMsg(int errCode, String msg) {
        Result result = new Result();
        result.setRespCode(errCode);
        result.setMsg(msg);
        return result;
    }

}
