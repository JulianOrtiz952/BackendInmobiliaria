package com.ufps.edu.co.backendInmobiliaria.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    private Integer id;

    private String type;
    private String transaction;
    private String location;
    private long price;
    private String description;
    private String state;

}