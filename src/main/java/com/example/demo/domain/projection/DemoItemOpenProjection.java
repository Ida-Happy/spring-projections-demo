package com.example.demo.domain.projection;

import org.springframework.beans.factory.annotation.Value;

public interface DemoItemOpenProjection {
    String getOrderId();
    String getSkuId();
    Integer getPrice();
    Integer getPurchaseNum();

    // SpEL
    @Value("#{target.price * (1 - target.tax)}")
    Double getPriceWithoutTax();

    // default method
    default Integer getTotalAmount() {
        return getPrice() * getPurchaseNum();
    }
}
