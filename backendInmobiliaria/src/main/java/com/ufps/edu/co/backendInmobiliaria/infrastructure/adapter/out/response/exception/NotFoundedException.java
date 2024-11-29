package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundedException extends RuntimeException{
    private String message;
    private String code;
    public NotFoundedException(){
        this.message="not founded :(";
        this.code="404";
    }

    public NotFoundedException(String message){
        this.message=message;
        this.code="404";
    }

}
