package com.ufps.edu.co.backendInmobiliaria.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "images")
@RequiredArgsConstructor
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String path;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "property_id")
    private Property property;

}
