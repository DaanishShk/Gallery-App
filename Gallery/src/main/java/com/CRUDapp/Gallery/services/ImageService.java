package com.CRUDapp.Gallery.services;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.domain.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return imageRepository.findImageByName(name);
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id).get();
    }

    public void addImage(Image image) {
        imageRepository.save(image);
    }

    public void editImage(Long id, String url, String description) {
        Image image = imageRepository.findById(id).get();
        image.setUrl(url);
        image.setDescription(description);
        imageRepository.save(image);
    }

    public void deleteImage(Long id){
        imageRepository.deleteById(id);
    }
}
