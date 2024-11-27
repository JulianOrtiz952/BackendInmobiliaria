package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.service.ImageService;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<String> createImage(@RequestBody Image image){
        imageService.createImage(image);
        return ResponseEntity.ok( "Image has been created"+image.getUrl());
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImage(){
        return ResponseEntity.ok(imageService.findAll());
    }

}
