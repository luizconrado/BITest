package com.example.restapi.bitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Orders")
public class Order {

    @Id
    int id;

    @Column(name = "OrderNo")
    String orderNo;

    @Column(name = "merchantId")
    String merchantId;

    @Column(name = "OrderVolume")
    BigDecimal orderVolume;

    @Column(name = "VoucherReduction")
    int voucherReduction;

    @Column(name = "OrderStatus")
    String orderStatus;

    @Column(name = "OrderCreated")
    java.sql.Timestamp orderCreated;

    @Column(name = "OrderShipped")
    java.sql.Timestamp orderShipped;

    @Column(name = "OrderPaid")
    java.sql.Timestamp orderPaid;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getOrderVolume() {
        return orderVolume;
    }

    public void setOrderVolume(BigDecimal orderVolume) {
        this.orderVolume = orderVolume;
    }

    public int getVoucherReduction() {
        return voucherReduction;
    }

    public void setVoucherReduction(int voucherReduction) {
        this.voucherReduction = voucherReduction;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Timestamp orderCreated) {
        this.orderCreated = orderCreated;
    }

    public Timestamp getOrderShipped() {
        return orderShipped;
    }

    public void setOrderShipped(Timestamp orderShipped) {
        this.orderShipped = orderShipped;
    }

    public Timestamp getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(Timestamp orderPaid) {
        this.orderPaid = orderPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order orders = (Order) o;
        return id == orders.id &&
                voucherReduction == orders.voucherReduction &&
                Objects.equals(orderNo, orders.orderNo) &&
                Objects.equals(merchantId, orders.merchantId) &&
                Objects.equals(orderVolume, orders.orderVolume) &&
                Objects.equals(orderStatus, orders.orderStatus) &&
                Objects.equals(orderCreated, orders.orderCreated) &&
                Objects.equals(orderShipped, orders.orderShipped) &&
                Objects.equals(orderPaid, orders.orderPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, merchantId, orderVolume, voucherReduction, orderStatus, orderCreated, orderShipped, orderPaid);
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", orderVolume=" + orderVolume +
                ", voucherReduction=" + voucherReduction +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCreated=" + orderCreated +
                ", orderShipped=" + orderShipped +
                ", orderPaid=" + orderPaid +
                '}';
    }
}
