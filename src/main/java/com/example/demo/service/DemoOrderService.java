package com.example.demo.service;

import com.example.demo.domain.DemoOrder;
import com.example.demo.domain.projection.*;
import com.example.demo.repo.DemoItemRepository;
import com.example.demo.repo.DemoOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoOrderService {
    private final DemoOrderRepository demoOrderRepository;
    private final DemoItemRepository demoItemRepository;

    public DemoOrder getOrderByOrderId(String orderId) {
        Assert.notNull(orderId, "The order id should not be NULL!");
        return this.demoOrderRepository.findOrderByOrderId(orderId);
    }

    public DemoOrderClosedProjection getOrderDetailsByOrderId(String orderId) {
        Assert.notNull(orderId, "The order id should not be NULL!");
        return this.demoOrderRepository.getOrderByOrderId(orderId);
    }

    public List<DemoItemOpenProjection> getItemDetailsByOrderId(String orderId) {
        Assert.notNull(orderId, "The order id should not be NULL!");
        return this.demoItemRepository.getItemsByOrderId(orderId);
    }

    public <T> T getOrderByOrderId(String orderId, boolean tidy) {
        if (tidy) {
            return (T) this.demoOrderRepository.getOrderByOrderId(orderId, DemoOrderClosedProjection.class);
        }
        return (T) this.demoOrderRepository.getOrderByOrderId(orderId, DemoOrder.class);
    }

    public List<DemoOrderRecord> getSucceedOrders() {
        return this.demoOrderRepository.getSucceedOrders();
    }

    public List<DemoOrderTotalRecord> getShopTotal() {
        return this.demoItemRepository.getTotalGroupByShop();
    }

    public List<DemoOrderTotalProjection> getShopTotalProjection() {
        return this.demoItemRepository.getTotalProjectionGroupByShop();
    }

    public List<DemoOrderProjection> getOrdersBySucceed(boolean succeed) {
        return this.demoOrderRepository.findDemoOrdersBySucceed(succeed);
    }
}
