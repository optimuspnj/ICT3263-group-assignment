package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "facilities")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addRoomFacility", procedureName = "addRoomFacility", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "fac_name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "image",type=String.class)} ),
        @NamedStoredProcedureQuery(name = "deleteRoomFacilityById", procedureName = "deleteRoomFacilityById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class)} )
})
public class Facility {
    @Id
    @Column(name = "fac_id", nullable = false)
    private Integer id;

    @Column(name = "fac_name", nullable = false, length = 50)
    private String facName;

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

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
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