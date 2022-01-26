package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.*;

import static com.bookstore.entity.OrderDetail.TABLE_NAME;

@Entity
@Table(name =TABLE_NAME)
public class OrderDetail extends BaseEntity<Long>{
    protected final static String TABLE_NAME = "order_detail";
    private final static String QUANTITY = "quantity";
    private final static String SUB_TOTAL = "sub_total";
    @Column(name = QUANTITY,nullable = false)
    private long quantity;
    @Column(name = SUB_TOTAL,nullable = false)
    private double subTotal;
    @ManyToOne
    private Books books;
    @ManyToOne
    private Order order;
    public OrderDetail() {
    }

    public OrderDetail(long quantity, double subTotal) {
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
