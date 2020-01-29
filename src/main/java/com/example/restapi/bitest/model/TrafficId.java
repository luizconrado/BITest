package com.example.restapi.bitest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class TrafficId implements Serializable {

    @NotNull
    @Column(name = "MerchantId")
    String merchantId;

    @NotNull
    @Column(name = "VisitDate")
    java.sql.Date visitDate;

    public TrafficId() {
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficId trafficId = (TrafficId) o;
        return Objects.equals(merchantId, trafficId.merchantId) &&
                Objects.equals(visitDate, trafficId.visitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, visitDate);
    }

    @Override
    public String toString() {
        return "TrafficId{" +
                "MerchantId='" + merchantId + '\'' +
                ", VisitDate=" + visitDate +
                '}';
    }
}
