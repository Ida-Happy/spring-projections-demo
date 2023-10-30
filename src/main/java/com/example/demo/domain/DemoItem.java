package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("demo_items_tbl")
public class DemoItem {
    @Id
    private Integer id;
    @MappedCollection(idColumn = "order_id")
    private String orderId;
    private String skuId;
    private String shopUrl;
    private Integer purchaseNum;
    private Integer price;
    private Double tax;
    private LocalDateTime createTime;
}
