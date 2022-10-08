package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "room_category")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addRoomCategory", procedureName = "addRoomCategory", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "cat_name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "cat_image",type=String.class)} ),
        @NamedStoredProcedureQuery(name = "deleteRoomCategoryById", procedureName = "deleteRoomCategoryById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class)} )
})


public class RoomCategory {
    @Id
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Column(name = "cat_name", nullable = false, length = 100)
    private String catName;

    @Column(name = "cat_image", nullable = false, length = 50)
    private String catImage;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}