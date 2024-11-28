package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.domain.dao.ImageRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.PropertyRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Image;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final PropertyRepository propertyRepository;

    private final String UPLOAD_DIRECTORY = "./uploads/images";

    public Image saveImage(MultipartFile file, Integer propertyId) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIRECTORY + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        Image image = new Image();
        image.setName(fileName);
        image.setPath(filePath.toString());
        // Aquí deberías establecer la propiedad asociada
        image.setProperty(getPropertyById(propertyId));

        return imageRepository.save(image);
    }

    private Property getPropertyById(Integer propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow();
    }

    public List<Image> getImagesByPropertyId(Integer propertyId) {
        return imageRepository.findByPropertyId(propertyId);
    }

    public void deleteImage(Integer imageId) throws IOException {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        Files.deleteIfExists(Paths.get(image.getPath()));
        imageRepository.delete(image);
    }

}