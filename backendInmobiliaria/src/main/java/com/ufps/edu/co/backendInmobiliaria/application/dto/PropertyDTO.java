package com.ufps.edu.co.backendInmobiliaria.application.dto;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.Image;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import com.ufps.edu.co.backendInmobiliaria.domain.extra.Address;
import com.ufps.edu.co.backendInmobiliaria.domain.extra.PropertyEstate;
import com.ufps.edu.co.backendInmobiliaria.domain.extra.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    private Integer id;

    private String title;
    private String description;
    private BigDecimal price;
    private int bedrooms;
    private int bathrooms;
    private double area;
    private PropertyType propertyType;
    private PropertyEstate propertyEstate;
    private Address address;
    private User owner;
    private List<Image> images;

}