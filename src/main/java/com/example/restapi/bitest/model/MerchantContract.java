package com.example.restapi.bitest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "MerchantContract")
public class MerchantContract {

    @Id
    @Column(name = "MerchantId")
    String merchantId;


//    https://www.baeldung.com/spring-boot-formatting-json-dates
//    @Column(name = "ContractStartDate")
//    LocalDate contractStartDate;
//
//    @Column(name = "ContractEndDate")
//    LocalDate contractEndDate;

//    @JsonFormat(pattern="yyyy-MM-dd", timezone="UTC")
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Berlin")
    @Column(name = "ContractStartDate")
    java.sql.Date contractStartDate;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Berlin")
    @Column(name = "ContractEndDate")
    java.sql.Date contractEndDate;

    @Column(name = "ContractYear")
    int contractYear;

    @Column(name = "FlgTestShop")
    int flgTestShop;


    public MerchantContract() {
    }


    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getContractYear() {
        return contractYear;
    }

    public void setContractYear(int contractYear) {
        this.contractYear = contractYear;
    }

    public int getFlgTestShop() {
        return flgTestShop;
    }

    public void setFlgTestShop(int flgTestShop) {
        this.flgTestShop = flgTestShop;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantContract that = (MerchantContract) o;
        return contractYear == that.contractYear &&
                flgTestShop == that.flgTestShop &&
                Objects.equals(merchantId, that.merchantId) &&
                Objects.equals(contractStartDate, that.contractStartDate) &&
                Objects.equals(contractEndDate, that.contractEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, contractStartDate, contractEndDate, contractYear, flgTestShop);
    }


    @Override
    public String toString() {
        return "MerchantContract{" +
                "merchantId='" + merchantId + '\'' +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", contractYear=" + contractYear +
                ", flgTestShop=" + flgTestShop +
                '}';
    }
}
