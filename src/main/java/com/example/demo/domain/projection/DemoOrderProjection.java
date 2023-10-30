package com.example.demo.domain.projection;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

public interface DemoOrderProjection {
    String getOrderId();

    Boolean getSucceed();

    @MappedCollection(idColumn = "order_id")
    Set<DemoItemOpenProjection> getItems();
}
