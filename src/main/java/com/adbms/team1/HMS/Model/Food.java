package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @Column(name = "food_id", nullable = false)
    private Integer id;

    @Column(name = "food_name", nullable = false, length = 50)
    private String foodName;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "price", nullable = false, precision = 10)
    private BigDecimal price;

    @Column(name = "image", nullable = false, length = 50)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_category", nullable = false)
    private FoodCategory foodCategory;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}