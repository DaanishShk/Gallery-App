package com.CRUDapp.Gallery.services;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.domain.ImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public List<Image> getImagesByPage(Integer pageNo) {
        Pageable paging = PageRequest.of(pageNo, 9, Sort.by("id"));
        Page<Image> pagedResult = imageRepository.findAll(paging);
        return pagedResult.getContent();
    }


    public Image getImageById(Long id) {
        return imageRepository.getById(id);
    }


    @Async
    public Image addImage(Image image) {
        boolean isImage = isValidImageUrl(image.getUrl());
        System.out.println(image.getName() + " is image? " + isImage);

        if (!isImage || image.getName().isEmpty() || image.getDescription().isEmpty()) {
            return image;
        }
        return imageRepository.save(image);
    }

    public boolean isValidImageUrl(String url) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL(url));
            if (image != null) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Async
    public void editImage(Long id, String url, String description) {
        Image image = imageRepository.findById(id).get();
        if(isValidImageUrl(url)) {
            image.setUrl(url);
        }
        image.setDescription(description);
        imageRepository.save(image);
    }


    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }


    public List<Image> searchImages(String query) {
        Pageable paging = PageRequest.of(0, 9, Sort.by("id"));
        Page<Image> pagedResult = imageRepository.findImageByNameContainingIgnoreCase(query, paging);
        return pagedResult.getContent();
    }
}
