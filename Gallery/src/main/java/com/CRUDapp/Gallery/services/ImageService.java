package com.CRUDapp.Gallery.services;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.domain.ImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Image> getImagesByPage(Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, 9, Sort.by("id"));
        Page<Image> pagedResult= imageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    public List<Image> getImagesByName(String name) {
        return imageRepository.findImageByName(name);
    }

    public Image getImageById(Long id) {
        return imageRepository.getById(id);
    }

    public Image addImage(Image image) {
        return imageRepository.save(image);
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



    public List<Image> searchImages(String query) {
        Pageable paging = PageRequest.of(0, 9, Sort.by("id"));
        Page<Image> pagedResult= imageRepository.findImageByNameContainingIgnoreCase(query,paging);
        return pagedResult.getContent();
    }
}
