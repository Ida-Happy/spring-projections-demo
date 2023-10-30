package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Table("demo_orders_tbl")
public class DemoOrder {
    @Id
    private String orderId;
    private Boolean succeed;
    private String orderStatus;
    private LocalDateTime createTime;
    @MappedCollection(idColumn = "order_id")
    Set<DemoItem> items;
}
