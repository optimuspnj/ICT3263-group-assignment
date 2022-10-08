package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "room_facilities")


public class RoomFacility {
    @Id
    @Column(name = "room_facility_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomCategory room;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoomCategory getRoom() {
        return room;
    }

    public void setRoom(RoomCategory room) {
        this.room = room;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}