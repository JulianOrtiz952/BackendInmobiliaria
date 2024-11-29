package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.exception;

public class RequestException extends RuntimeException {

    private String code;
    public RequestException(String code, String message){
        super(message);
        this.code=code;
    }

}
