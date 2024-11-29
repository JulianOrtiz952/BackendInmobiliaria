package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.application.dto.PropertyDTO;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.AccountRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Account;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.PropertyRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.extra.PropertyEstate;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.request.SellRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final AccountRepository accountRepository;

    public String createProperty(Property property) {
        if(property!=null){
            property.setPropertyEstate(PropertyEstate.AVAILABLE);
            propertyRepository.save(property);
            return "property has been created";
        }
        throw new RuntimeException("user has a empty place");
    }

    public void deleteProperty(Integer id) {
        if (!propertyRepository.existsById(id)) throw new RuntimeException("Property not found with id: " + id);
        propertyRepository.deleteById(id);
    }

    public List<PropertyDTO> getAllProperties() {

        List<Property> properties = propertyRepository.findAll();

        return properties.stream().map(property -> {
            return PropertyDTO.builder()
                    .id(property.getId())
                    .title(property.getTitle())
                    .description(property.getDescription())
                    .price(property.getPrice())
                    .bedrooms(property.getBedrooms())
                    .bathrooms(property.getBathrooms())
                    .area(property.getArea())
                    .propertyType(property.getPropertyType())
                    .address(property.getAddress()) // Asumimos que es un objeto Address simple
                    .images(property.getImages()) // Lista de imágenes asociadas a la propiedad
                    .build();
        }).collect(Collectors.toList());
    }


    public Property getPropertyById(Integer id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
    }

    public List<PropertyDTO> getPropertiesByState(){

        List<Property> properties = propertyRepository.findAll();

        return properties.stream().filter(property -> property.getPropertyEstate() != null && property.getPropertyEstate().ordinal() == 0).map(property -> {
            return  PropertyDTO.builder()
                    .id(property.getId())
                    .title(property.getTitle())
                    .description(property.getDescription())
                    .price(property.getPrice())
                    .bedrooms(property.getBedrooms())
                    .bathrooms(property.getBathrooms())
                    .area(property.getArea())
                    .propertyType(property.getPropertyType())
                    .address(property.getAddress()) // Asumimos que es un objeto Address simple
                    .images(property.getImages()) // Lista de imágenes asociadas a la propiedad
                    .build();
        }).collect(Collectors.toList());
    }

    public String sellProperty(SellRequest sellRequest){
        Integer id = sellRequest.getId();
        Integer userId = sellRequest.getUserId();
        Property property = propertyRepository.findById(id).orElseThrow();
        Account account = accountRepository.findByUserId(userId);
        BigDecimal valueProperty = property.getPrice();
        BigDecimal valueBalance = account.getBalance();
        if( valueBalance.compareTo(valueProperty) > 0) {
            account.setBalance(valueBalance.subtract(valueProperty));
            propertyRepository.deleteById(id);
            return "Property sell";
        }
        else return "naos";
    }

}