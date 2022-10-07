package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookings")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllBookings",procedureName = "getAllBookings"),
        @NamedStoredProcedureQuery(name = "getBookingById", procedureName = "getBookingById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "booking_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "deleteBookingById", procedureName = "deleteBookingById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "booking_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "addBooking", procedureName = "addBooking", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "bdate",type= Date.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "adate",type=Date.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ddate",type=Date.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "amount",type=Double.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "cus",type=Integer.class)} )
})

public class Booking {
    @Id
    @Column(name = "booking_id", nullable = false)
    private Integer id;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "booking_amount", nullable = false)
    private Double bookingAmount;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "cus_id", nullable = false)
//    private Customer cus;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

//    public Customer getCus() {
//        return cus;
//    }
//
//    public void setCus(Customer cus) {
//        this.cus = cus;
//    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}