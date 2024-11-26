package com.ufps.edu.co.backendInmobiliaria.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Integer id;
    private String email;
    private String name;
    private String lastName;
    private String role;  // Representa el rol como String para facilitar la transferencia

}