package com.adbms.team1.HMS.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "food_orders")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteFoodOrderById", procedureName = "deleteFoodOrderById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "fo_id", type = Integer.class)}),
        @NamedStoredProcedureQuery(name = "updateFoodOrderById", procedureName = "updateFoodOrderById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "fo_id",type=Integer.class), @StoredProcedureParameter(mode = ParameterMode.IN,name = "date",type= LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "total_payment",type=Double.class)} ),
        @NamedStoredProcedureQuery(name = "addFoodOrder", procedureName = "addFoodOrder", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "date",type= LocalDate.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "cus_id",type=Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "total_payment",type=Double.class)} )

})

public class FoodOrder {
    @Id
    @Column(name = "fo_id")
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    public Integer getCus_id() {
        return cus_id;
    }

    public void setCus_id(Integer cus_id) {
        this.cus_id = cus_id;
    }

    @Column(name = "cus_id")
    private Integer cus_id;


    @Column(name = "total_payment")
    private Double totalPayment;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }





    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}