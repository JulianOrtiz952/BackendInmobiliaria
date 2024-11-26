package com.ufps.edu.co.backendInmobiliaria.domain.entity;

import com.ufps.edu.co.backendInmobiliaria.domain.extra.PropertyType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private BigDecimal price;
    private int bedrooms;
    private int bathrooms;
    private double area;
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;
}
