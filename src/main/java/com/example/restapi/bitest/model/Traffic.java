package com.example.restapi.bitest.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Traffic")
public class Traffic {

    @EmbeddedId
    private TrafficId id;

//    @Column(name = "MerchantId")
//    String merchantId;
//
//    @Column(name = "VisitDate")
//    java.sql.Date visitDate;

    @Column(name = "Visits")
    int visits;

    @Column(name = "Pageviews")
    int pageviews;

    public Traffic() {
    }


    public TrafficId getId() {
        return id;
    }

    public void setId(TrafficId id) {
        this.id = id;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traffic traffic = (Traffic) o;
        return visits == traffic.visits &&
                pageviews == traffic.pageviews &&
                Objects.equals(id, traffic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visits, pageviews);
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "id=" + id +
                ", visits=" + visits +
                ", pageviews=" + pageviews +
                '}';
    }
}
