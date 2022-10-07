package com.adbms.team1.HMS.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gallery")
public class Gallery {
    @Id
    @Column(name = "gal_id", nullable = false)
    private Integer id;

    @Column(name = "gal_title", nullable = false, length = 50)
    private String galTitle;

    @Column(name = "gal_category", nullable = false)
    private Integer galCategory;

    @Column(name = "image", nullable = false, length = 50)
    private String image;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGalTitle() {
        return galTitle;
    }

    public void setGalTitle(String galTitle) {
        this.galTitle = galTitle;
    }

    public Integer getGalCategory() {
        return galCategory;
    }

    public void setGalCategory(Integer galCategory) {
        this.galCategory = galCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}