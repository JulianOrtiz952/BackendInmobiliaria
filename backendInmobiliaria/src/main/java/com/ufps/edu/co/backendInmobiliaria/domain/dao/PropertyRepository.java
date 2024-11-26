package com.ufps.edu.co.backendInmobiliaria.domain.dao;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
