package com.example.demo.controller;

import com.example.demo.client.OrderClient;
import com.example.demo.domain.DemoOrder;
import com.example.demo.domain.projection.*;
import com.example.demo.service.DemoOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoOrderController {

    private final DemoOrderService demoOrderService;
    private final OrderClient orderClient;
    private final SpelAwareProxyProjectionFactory factory;

    // Normal
    @GetMapping("/order/{orderId}")
    public ResponseEntity<DemoOrder> getOrderByOrderId(@PathVariable String orderId) {
        return new ResponseEntity<>(this.demoOrderService.getOrderByOrderId(orderId), HttpStatus.OK);
    }

    // Closed Interface
    @GetMapping("/projection/order/detail/{orderId}")
    public ResponseEntity<DemoOrderClosedProjection> getOrderByItemNum(@PathVariable String orderId) {
        return new ResponseEntity<>(this.demoOrderService.getOrderDetailsByOrderId(orderId), HttpStatus.OK);
    }

    // Open Interface
    @GetMapping("/projection/item/detail/{orderId}")
    public ResponseEntity<List<DemoItemOpenProjection>> getOrderDetails(@PathVariable String orderId) {
        return ResponseEntity.ok(this.demoOrderService.getItemDetailsByOrderId(orderId));
    }

    // DTO
    @GetMapping("/projection/succeed/orders")
    public ResponseEntity<List<DemoOrderRecord>> getSucceedOrders() {
        return ResponseEntity.ok(this.demoOrderService.getSucceedOrders());
    }

    // Dynamic
    @GetMapping("/projection/orders/dynamic/{orderId}")
    public ResponseEntity<?> getOrdersDynamic(@PathVariable String orderId, @RequestParam(required = false, defaultValue = "false") boolean tidy) {
        return ResponseEntity.ok(this.demoOrderService.getOrderByOrderId(orderId, tidy));
    }

    // Result Mapping - DTO
    @GetMapping("/projection/order/total/record")
    public ResponseEntity<List<DemoOrderTotalRecord>> getOrderTotal() {
        return ResponseEntity.ok(this.demoOrderService.getShopTotal());
    }

    // Result Mapping - interface
    @GetMapping("/projection/order/total/interface")
    public ResponseEntity<List<DemoOrderTotalProjection>> getOrderTotalInterface() {
        return ResponseEntity.ok(this.demoOrderService.getShopTotalProjection());
    }

    @GetMapping("projection/whole/order/projections/{succeed}")
    public ResponseEntity<List<DemoOrderProjection>> getWholeOrder(@PathVariable boolean succeed) {
        return ResponseEntity.ok(this.demoOrderService.getOrdersBySucceed(succeed));
    }

    @GetMapping("/demo/web/layer/{orderId}")
    public DemoOrderClosedProjection getOrderByWebLayer(@PathVariable String orderId) {
        return factory.createProjection(DemoOrderClosedProjection.class, orderClient.getOrderByOrderId(orderId));
    }
}
