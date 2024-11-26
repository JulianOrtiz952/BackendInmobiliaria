package com.ufps.edu.co.backendInmobiliaria.domain.dao;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import com.ufps.edu.co.backendInmobiliaria.domain.extra.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findByPropertyType(PropertyType type);
    List<Property> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

}
