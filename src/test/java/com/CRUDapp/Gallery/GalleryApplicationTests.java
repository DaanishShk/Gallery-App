package com.CRUDapp.Gallery;

import com.CRUDapp.Gallery.controller.ImageController;
import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.services.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GalleryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageController imageController;


    @Test
    void contextLoads() {
        assertThat(imageController).isNotNull();
    }

    @Test
    void saveAndRetrieveImage() {
        Image image = new Image("testImage", "https://paulryan.com.au/wp-content/uploads/2015/01/high-resolution-wallpapers-25.jpg", "description");

        Image savedImage = imageService.addImage(image);
        System.out.println(savedImage + "  " + savedImage.getId());
        assertNotNull(savedImage);
        assertNotNull(savedImage.getId());
        assertEquals("testImage", savedImage.getName());
    }


    @Test
    @Transactional
    void addAndEditImage() {

        Image image = new Image("editImage", "https://images.unsplash.com/photo-1543373014-cfe4f4bc1cdf?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGlnaCUyMHJlc29sdXRpb258ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80", "Lorem ipsum");
        image.setDescription("First description");

        Image savedImage = imageService.addImage(image);
        assertNotNull(savedImage);

        imageService.editImage(savedImage.getId(), "", "Second description");

        assertEquals("Second description", imageService.getImageById(savedImage.getId()).getDescription());
    }


    @Test
    void testHomePageConnection() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

}
