package com.ufps.edu.co.backendInmobiliaria.domain.entity;

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

    private String url;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
