package com.CRUDapp.Gallery;

import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.services.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("default")
public class GalleryApplication implements CommandLineRunner {

    private final ImageService imageService;

    public GalleryApplication(ImageService imageService) {
        this.imageService = imageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GalleryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.addImage(new Image("Tropical", "https://paulryan.com.au/wp-content/uploads/2015/01/high-resolution-wallpapers-25.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Sunset", "https://images.unsplash.com/photo-1543373014-cfe4f4bc1cdf?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGlnaCUyMHJlc29sdXRpb258ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Eiffel Tower", "https://www.teahub.io/photos/full/13-137539_full-screen-high-res-desktop-backgrounds-hd-wallpapers.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Dew Drops", "http://1.bp.blogspot.com/-VhYXsIq0dtA/T-md0Wu7DGI/AAAAAAAAAKs/-g7PbCmcbzQ/s1600/3.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("World Map", "https://wallpapercave.com/wp/Dq6o3uI.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Sea Turtle", "https://api.timeforkids.com/wp-content/uploads/2021/07/turtle1.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Stream", "https://speckyboy.com/wp-content/uploads/2020/11/high-resolution-4k-desktop-wallpaper-34.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("NASA", "https://mars.nasa.gov/system/resources/detail_files/25609_1-PIA24428-1200.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Space", "https://mymodernmet.com/wp/wp-content/uploads/2019/06/nasa-free-photos-online-thumbnail.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Abstract", "https://speckyboy.com/wp-content/uploads/2020/11/high-resolution-4k-desktop-wallpaper-37.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Birds Eye", "https://shotkit.com/wp-content/uploads/2021/05/birdsev-14.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
        imageService.addImage(new Image("Bike", "https://www.iamabiker.com/wp-content/uploads/2019/11/2020-BMW-S1000-XR-HD-high-res-1.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel pretium lectus quam id leo in vitae turpis. Et netus et malesuada fames ac turpis egestas sed. Adipiscing elit duis tristique sollicitudin nibh sit amet. Tortor posuere ac ut consequat semper."));
    }
}
