package com.ufps.edu.co.backendInmobiliaria.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
    private Integer id;
    private long accountNumber;
    private BigDecimal balance;
    private Integer userId;
}
