package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rooms")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addRoom", procedureName = "addRoom", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_description",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_status",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "daily_rate",type=BigDecimal.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_qty",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "max_guest",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_image",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_category",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "deleteRoomById", procedureName = "deleteRoomById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "updateRoomById", procedureName = "updateRoomById",  parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_name",type= String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_description",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_status",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "daily_rate",type=BigDecimal.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_qty",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "max_guest",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_image",type=String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "room_category",type=Integer.class)} ),

})
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    private Integer id;

    @Column(name = "room_name", nullable = false, length = 100)
    private String roomName;

    @Column(name = "room_description", nullable = false, length = 2000)
    private String roomDescription;

    @Column(name = "room_status", nullable = false, length = 20)
    private String roomStatus;

    @Column(name = "daily_rate", nullable = false, precision = 10)
    private BigDecimal dailyRate;

    @Column(name = "room_qty", nullable = false)
    private Integer roomQty;

    @Column(name = "max_guest", nullable = false)
    private Integer maxGuest;

    @Column(name = "room_image", nullable = false, length = 50)
    private String roomImage;


    private Integer roomCategory;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getRoomQty() {
        return roomQty;
    }

    public void setRoomQty(Integer roomQty) {
        this.roomQty = roomQty;
    }

    public Integer getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(Integer maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public Integer getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(Integer roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}