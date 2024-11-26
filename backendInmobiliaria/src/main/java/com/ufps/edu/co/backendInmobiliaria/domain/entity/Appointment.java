package com.ufps.edu.co.backendInmobiliaria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;

    private LocalDateTime dateTime;
    private String status;

}
