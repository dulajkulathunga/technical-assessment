package com.technical.assessment.model;

import javax.persistence.*;

@Entity
@Table(name = "product_discount")
public class ProductDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long DiscountId;

    @Column(name = "discount")
    private  int discount;

    public Long getDiscountId() {
        return DiscountId;
    }

    public void setDiscountId(Long discountId) {
        DiscountId = discountId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
