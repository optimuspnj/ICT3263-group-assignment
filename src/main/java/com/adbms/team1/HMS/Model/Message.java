package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "messages")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addMessage", procedureName = "addMessage", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "email",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "phone",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "title",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "message",type=String.class)} ),
        @NamedStoredProcedureQuery(name = "deleteMessageById", procedureName = "deleteMessageById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class)} )
})

public class Message {
    @Id
    @Column(name = "msg_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "message", nullable = false, length = 200)
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}