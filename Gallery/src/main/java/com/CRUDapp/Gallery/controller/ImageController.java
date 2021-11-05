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
        model.addAttribute("images",imageService.getAllImages());
        return "index";
    }

    @GetMapping("/show/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("image",imageService.getImageById(id));
        return "details";
    }

    @GetMapping("/new")
    public String addImagePage(Model model) {
        model.addAttribute("image", new Image());
        return "addImage";
    }

    @PostMapping("/")
    public String postImage(@ModelAttribute Image image) {
        imageService.addImage(image);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editImage(@PathVariable Long id, Model model) {
        model.addAttribute("image",imageService.getImageById(id));
        return "editImage";
    }

    @PostMapping("/{id}/edit")
    public String putImage(@PathVariable Long id, @RequestBody String url, @RequestBody String description) {
        imageService.editImage(id, url, description);
        return "redirect:/"+id+"/edit";
    }

    @PostMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return "redirect:/";
    }
}
