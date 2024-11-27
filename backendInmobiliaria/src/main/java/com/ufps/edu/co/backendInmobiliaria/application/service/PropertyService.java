package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.application.dto.PropertyDTO;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public String createProperty(Property property) {
        if(property!=null){
            propertyRepository.save(property);
            return "property has been created";
        }
        throw new RuntimeException("user has a empty place");
    }


//
//    public PropertyDTO updateProperty(Integer id, Property updatedProperty) {
//        Property existingProperty = propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
//
//        if (updatedProperty.getPropertyType() != null) {
//            existingProperty.setType(updatedProperty.getType());
//        }
//        if (updatedProperty.getTransaction() != null) {
//            existingProperty.setTransaction(updatedProperty.getTransaction());
//        }
//        if (updatedProperty.getLocation() != null) {
//            existingProperty.setLocation(updatedProperty.getLocation());
//        }
//        if (updatedProperty.getPrice() != 0) {
//            existingProperty.setPrice(updatedProperty.getPrice());
//        }
//        if (updatedProperty.getDescription() != null) {
//            existingProperty.setDescription(updatedProperty.getDescription());
//        }
//        return PropertyDTO.builder().description(existingProperty.getDescription()).price(existingProperty.getPrice()).state(existingProperty.getState()).type(existingProperty.getType()).location(existingProperty.getLocation()).transaction(existingProperty.getTransaction()).build();
//    }

    public void deleteProperty(Integer id) {
        if (!propertyRepository.existsById(id)) throw new RuntimeException("Property not found with id: " + id);
        propertyRepository.deleteById(id);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Integer id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
    }

}