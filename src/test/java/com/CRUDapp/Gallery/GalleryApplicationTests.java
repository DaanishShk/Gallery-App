package com.CRUDapp.Gallery;

import com.CRUDapp.Gallery.controller.ImageController;
import com.CRUDapp.Gallery.domain.Image;
import com.CRUDapp.Gallery.domain.ImageRepository;
import com.CRUDapp.Gallery.services.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


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
		Image image = new Image();
		image.setName("testImage");

		Image savedImage = imageService.addImage(image);

		assertNotNull(savedImage);
		assertNotNull(savedImage.getId());
		assertEquals("testImage", savedImage.getName());
	}


	@Test
	@Transactional
	void addAndEditImage() {

		Image image = new Image();
		image.setName("editImage");
		image.setDescription("First description");

		Image savedImage = imageService.addImage(image);
		assertNotNull(savedImage);

		imageService.editImage(savedImage.getId(), "", "Second description");

		assertEquals("Second description", imageService.getImageById(savedImage.getId()).getDescription());
	}



	@Test
	void testHomePageConnection() throws Exception{
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

}
