package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.exception;

public class EmptyException extends RuntimeException{

    private String message;
    private String code;

    public EmptyException(){
        this.message="requirements are missing";
        this.code="400";
    }

    public EmptyException(String message){
        this.message=message + " is missing";
        this.code="400";
    }
}
