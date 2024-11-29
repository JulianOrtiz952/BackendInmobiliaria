package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.dto.PropertyDTO;
import com.ufps.edu.co.backendInmobiliaria.application.service.PropertyService;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.SellRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getPropertiesByState());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Integer id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @PostMapping
    public ResponseEntity<String> createProperty(@RequestBody Property property) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.createProperty(property));
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellProperty(@RequestBody SellRequest sellRequest){
        return ResponseEntity.ok(propertyService.sellProperty(sellRequest));
    }



}