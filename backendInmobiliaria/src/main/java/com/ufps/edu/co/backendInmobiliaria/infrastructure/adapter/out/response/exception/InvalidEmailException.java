package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.exception;

public class InvalidEmailException extends RuntimeException{
    private String message;
    private String code;

    public InvalidEmailException(){
        this.message="user not founded with email";
        this.code="409";
    }

    public InvalidEmailException(String message){
        this.message=message;
        this.code="409";
    }
}
