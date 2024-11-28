package com.ufps.edu.co.backendInmobiliaria.domain.dao;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findByPropertyId(Integer propertyId);
}
