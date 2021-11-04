package com.CRUDapp.Gallery.services;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.domain.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public List<Image> getImagesByName(String name) {
        return imageRepository.findImageByImgName(name);
    }
}
