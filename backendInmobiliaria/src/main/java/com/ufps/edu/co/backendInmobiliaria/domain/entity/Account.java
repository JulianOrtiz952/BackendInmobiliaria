package com.ufps.edu.co.backendInmobiliaria.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account", nullable = false)
    private long account;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(name = "account_number", nullable = false)
    private long accountNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
