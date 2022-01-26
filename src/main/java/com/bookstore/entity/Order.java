package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

import static com.bookstore.entity.Order.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Order extends BaseEntity<Long> {
    protected final static String TABLE_NAME = "orders";
    private final static String ORDER_TIME = "order_time";
    private final static String SHIPPING_ADDRESS = "shipping_address";
    private final static String RECIPIENT_PHONE = "recipient_phone";
    private final static String PAYMENT_METHOD = "payment_method";
    private final static String TOTAL = "total";
    private final static String STATUS = "status";
    @Column(name = ORDER_TIME, nullable = false)
    private Timestamp orderTime;
    @Column(name = SHIPPING_ADDRESS, nullable = false)
    private String shippingAddress;
    @Column(name = RECIPIENT_PHONE, nullable = false)
    private String recipientPhone;
    @Column(name = PAYMENT_METHOD, nullable = false)
    private String paymentMethod;
    @Column(name = TOTAL, nullable = false)
    private double total;
    @Column(name = STATUS, nullable = false)
    private String status;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

   @ManyToOne
   private Customer customer;

    public Order() {
    }

    public Order(Timestamp orderTime, String shippingAddress, String recipientPhone, String paymentMethod, double total, String status) {
        this.orderTime = orderTime;
        this.shippingAddress = shippingAddress;
        this.recipientPhone = recipientPhone;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.status = status;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
