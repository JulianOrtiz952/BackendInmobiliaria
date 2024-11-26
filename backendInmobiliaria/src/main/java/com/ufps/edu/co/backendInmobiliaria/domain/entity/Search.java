package com.ufps.edu.co.backendInmobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "searches")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String criteria;
    private LocalDateTime searchDate;


}
