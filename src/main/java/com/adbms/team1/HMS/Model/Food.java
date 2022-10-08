package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "foods")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteFoodById", procedureName = "deleteFoodById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "f_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "updateFoodById", procedureName = "updateFoodById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fname",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "descr",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fprice",type=Double.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fimage",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fcategory",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "addFood", procedureName = "addFood", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "fname",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "descr",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fprice",type=Double.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fimage",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "fcategory",type=Integer.class)} )
})

public class Food {
    @Id
    @Column(name = "food_id")
    private Integer id;

    @Column(name = "food_name", length = 50)
    private String foodName;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "price", precision = 10)
    private Double price;

    @Column(name = "image", length = 50)
    private String image;

    @Column(name = "food_category")
    private Integer food_category;

    public Integer getFood_category() {
        return food_category;
    }

    public void setFood_category(Integer food_category) {
        this.food_category = food_category;
    }
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "food_category", nullable = false)
//    private FoodCategory foodCategory;

    @Column(name = "is_deleted")
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public FoodCategory getFoodCategory() {
//        return foodCategory;
//    }

//    public void setFoodCategory(FoodCategory foodCategory) {
//        this.foodCategory = foodCategory;
//    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}