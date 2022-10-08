package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllBookings",procedureName = "getAllBookings"),
        @NamedStoredProcedureQuery(name = "getBookingById", procedureName = "getBookingById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "booking_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "deleteBookingById", procedureName = "deleteBookingById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "booking_id",type=Integer.class)} ),
        @NamedStoredProcedureQuery(name = "updateBookingById", procedureName = "updateBookingById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type=Integer.class), @StoredProcedureParameter(mode = ParameterMode.IN,name = "bdate",type= LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "adate",type=LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ddate",type=LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "amount",type=Double.class)} ),
        @NamedStoredProcedureQuery(name = "addBooking", procedureName = "addBooking", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "bdate",type= LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "adate",type=LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ddate",type=LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "amount",type=Double.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "cus",type=Integer.class)} )
})

public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "booking_amount")
    private Double bookingAmount;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Column(name = "cus_id")
    private Integer cusId;

    @Column(name = "is_deleted")
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}