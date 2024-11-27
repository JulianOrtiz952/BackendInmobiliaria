package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.domain.dao.ImageRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Image createImage(Image image){
        return imageRepository.save(image);
    }

    public List<Image> findAll(){
        return imageRepository.findAll();
    }

}