package com.kenshine.exceptionCapture.exception;


/**
 * @author kenshine
 */
public class DuplicateKeyException extends Exception {

    public DuplicateKeyException(String message) {
        super(message);
    }
}