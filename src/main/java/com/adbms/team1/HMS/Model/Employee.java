package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "employees")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteEmployeeById", procedureName = "deleteEmployeeById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "emp_id", type = Integer.class)}),
        @NamedStoredProcedureQuery(name = "updateEmployeeById", procedureName = "updateEmployeeById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "emp_id",type=Integer.class), @StoredProcedureParameter(mode = ParameterMode.IN,name = "name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "phone",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "email",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "type",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "password",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "profile",type=String.class)} ),
        @NamedStoredProcedureQuery(name = "addEmployee", procedureName = "addEmployee", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "phone",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "email",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "type",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "password",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "profile",type=String.class)} )
})

public class Employee {
    @Id
    @Column(name = "emp_id", nullable = false)
    private Integer id;

    @Column(name = "emp_name", nullable = false, length = 50)
    private String empName;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "profile_pic", nullable = false, length = 20)
    private String profilePic;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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