package com.adbms.team1.HMS.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_sequence")
public class HibernateSequence {
    @Column(name = "next_val")
    private Long nextVal;

    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

    //TODO [JPA Buddy] generate columns from DB
}