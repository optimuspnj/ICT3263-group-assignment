package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteCustomerById", procedureName = "deleteCustomerById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "cus_id", type = Integer.class)}),
        @NamedStoredProcedureQuery(name = "updateCustomerById", procedureName = "updateCustomerById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "cus_id",type=Integer.class), @StoredProcedureParameter(mode = ParameterMode.IN,name = "name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "email",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "address",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "nic",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "phone",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "password",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "profile",type=String.class)} ),
        @NamedStoredProcedureQuery(name = "addCustomer", procedureName = "addCustomer", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "email",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "address",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "nic",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "phone",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "password",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "profile",type=String.class)} )
})

public class Customer {
    @Id
    @Column(name = "cus_id", nullable = false)
    private Integer id;

    @Column(name = "cus_name", nullable = false, length = 100)
    private String cusName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "nic", nullable = false, length = 12)
    private String nic;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "profile_pic", nullable = false, length = 50)
    private String profilePic;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}