package com.technobrain.trips.security.exception;

/**
 * @author hhill
 */
public class AuthenticationException extends Throwable {

    public AuthenticationException(){
        super();
    }
    
    public AuthenticationException(String msg){
        super(msg);
    }
}
