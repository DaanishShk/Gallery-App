package com.CRUDapp.Gallery.controller;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute(imageService.getAllImages());
        return "index";
    }

    @GetMapping("/show/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute(imageService.getImageById(id));
        return "details";
    }

    @GetMapping("/new")
    public String addImagePage() {
        return "addForm";
    }

    @PostMapping("/")
    public String postImage(@ModelAttribute Image image) {
        imageService.addImage(image);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editImage(@PathVariable Long id, Model model) {
        model.addAttribute(imageService.getImageById(id));
        return "editForm";
    }

    @PutMapping("/{id}/edit")
    public String putImage(@PathVariable Long id, @ModelAttribute Image image) {
        imageService.editImage(imageService.getImageById(id), image);
        return "redirect:/"+id+"/edit";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return "redirect:/";
    }
}
