package com.CRUDapp.Gallery.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findImageByName(String name);

    Page<Image> findImageByNameContainingIgnoreCase(String searchQuery, Pageable pageable);

}
