package com.kenshine.catchtest;

class CustomException extends RuntimeException {
    private final int code;
 
    public CustomException(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
}
