package com.CRUDapp.Gallery.controller;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(defaultValue = "0") Integer pageNo) {

        if (pageNo < 0) pageNo = 0;

        List<Image> images = imageService.getImagesByPage(pageNo);
        if (pageNo != 0 && images.isEmpty()) {
            pageNo--;
            images = imageService.getImagesByPage(pageNo);
        }

        model.addAttribute("images", images);
        model.addAttribute("pageNo", pageNo);
        return "index";
    }


    @GetMapping("/show/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("image", imageService.getImageById(id));
        return "details";
    }


    @GetMapping("/new")
    public String addImagePage(Model model) {
        model.addAttribute("image", new Image());
        return "addImage";
    }

    @PostMapping("/new")
    public String postImage(@ModelAttribute Image image) {
        imageService.addImage(image);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String editImage(@PathVariable Long id, Model model) {
        System.out.println(imageService.getImageById(id));
        model.addAttribute("image", imageService.getImageById(id));
        return "editImage";
    }

    @PostMapping("/{id}/edit")
    public String putImage(@PathVariable Long id, @RequestParam String url, @RequestParam String description) {
        System.out.println(url + "  " + description);
        imageService.editImage(id, url, description);
        return "redirect:/" + id + "/edit";
    }


    @PostMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return "redirect:/";
    }
}
