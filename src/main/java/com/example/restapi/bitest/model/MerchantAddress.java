package com.example.restapi.bitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "MerchantAddress")
public class MerchantAddress {

    @Id
    @Column(name = "MerchantId")
    String merchantId;

    @Column(name = "ContactGender")
    String contactGender;

    @Column(name = "AddressCity")
    String addressCity;

    @Column(name = "AddressCountry")
    String addressCountry;

    @Column(name = "FlgHadFirstSale")
    int flgHadFirstSale;

    public MerchantAddress() {
    }


    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getContactGender() {
        return contactGender;
    }

    public void setContactGender(String contactGender) {
        this.contactGender = contactGender;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public int getFlgHadFirstSale() {
        return flgHadFirstSale;
    }

    public void setFlgHadFirstSale(int flgHadFirstSale) {
        this.flgHadFirstSale = flgHadFirstSale;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantAddress that = (MerchantAddress) o;
        return flgHadFirstSale == that.flgHadFirstSale &&
                Objects.equals(merchantId, that.merchantId) &&
                Objects.equals(contactGender, that.contactGender) &&
                Objects.equals(addressCity, that.addressCity) &&
                Objects.equals(addressCountry, that.addressCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, contactGender, addressCity, addressCountry, flgHadFirstSale);
    }

    @Override
    public String toString() {
        return "MerchantAddress{" +
                "merchantId='" + merchantId + '\'' +
                ", contactGender='" + contactGender + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                ", flgHadFirstSale=" + flgHadFirstSale +
                '}';
    }
}
