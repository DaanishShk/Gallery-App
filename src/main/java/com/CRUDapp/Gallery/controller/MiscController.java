package com.CRUDapp.Gallery.controller;

import com.CRUDapp.Gallery.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiscController {

    private final ImageService imageService;


    public MiscController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        System.out.println(query);
        model.addAttribute("images", imageService.searchImages(query));
        System.out.println(imageService.searchImages(query));
        model.addAttribute("pageNo", 0);
        return "index";
    }

}
