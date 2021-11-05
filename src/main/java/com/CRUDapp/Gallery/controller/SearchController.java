package com.CRUDapp.Gallery.controller;

import com.CRUDapp.Gallery.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final ImageService imageService;


    public SearchController(ImageService imageService) {
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
