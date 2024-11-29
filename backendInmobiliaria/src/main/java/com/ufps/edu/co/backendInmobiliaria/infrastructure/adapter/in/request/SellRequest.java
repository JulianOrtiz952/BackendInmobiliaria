package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SellRequest {

    private Integer id;
    private Integer userId;

}
