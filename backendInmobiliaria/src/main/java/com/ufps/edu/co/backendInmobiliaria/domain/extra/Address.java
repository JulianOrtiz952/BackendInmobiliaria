package com.ufps.edu.co.backendInmobiliaria.domain.extra;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
