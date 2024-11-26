package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {

    private String name;
    private String lastName;
    private String email;
    private String password;

}
