package com.CRUDapp.Gallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image extends AbstractPersistable<Long> {

    @Column(length = 50)
    private String name;

    @Column(length = 400)
    private String url;

    @Column(length = 600)
    private String description;

}
