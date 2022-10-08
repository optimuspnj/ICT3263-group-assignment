package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "food_category")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteFoodCategoryById", procedureName = "deleteFoodCategoryById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type= Integer.class)} ),
        @NamedStoredProcedureQuery(name = "addFoodCategory", procedureName = "addFoodCategory", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "f_category",type= String.class)} )
})

public class FoodCategory {
    @Id
    @Column(name = "fc_id")
    private Integer id;

    @Column(name = "fc_name", length = 50)
    private String fcName;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcName() {
        return fcName;
    }

    public void setFcName(String fcName) {
        this.fcName = fcName;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}