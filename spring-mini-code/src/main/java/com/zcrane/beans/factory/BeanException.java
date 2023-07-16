package com.zcrane.beans.factory;

/**
 * @author zcrane
 * @date 2023年07月16日 21:34
 */
public class BeanException extends RuntimeException {
    public BeanException(String msg, Exception e) {
        super(msg,e);
    }

    public BeanException(String msg) {
        super(msg);
    }
}
