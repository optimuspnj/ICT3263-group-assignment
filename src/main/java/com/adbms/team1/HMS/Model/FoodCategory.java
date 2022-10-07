package com.adbms.team1.HMS.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_category")
public class FoodCategory {
    @Id
    @Column(name = "fc_id", nullable = false)
    private Integer id;

    @Column(name = "fc_name", nullable = false, length = 50)
    private String fcName;

    @Column(name = "is_deleted", nullable = false)
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