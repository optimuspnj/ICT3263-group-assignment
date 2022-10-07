package com.adbms.team1.HMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "booking_rooms")
public class BookingRoom {
    @Id
    @Column(name = "br_id", nullable = false)
    private Integer id;

    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "room_count", nullable = false)
    private Integer roomCount;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}