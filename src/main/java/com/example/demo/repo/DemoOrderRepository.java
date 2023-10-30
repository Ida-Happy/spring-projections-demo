package com.example.demo.repo;

import com.example.demo.domain.DemoOrder;
import com.example.demo.domain.projection.DemoOrderClosedProjection;
import com.example.demo.domain.projection.DemoOrderProjection;
import com.example.demo.domain.projection.DemoOrderRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoOrderRepository extends CrudRepository<DemoOrder, String> {

    DemoOrder findOrderByOrderId(String orderId);

    DemoOrderClosedProjection getOrderByOrderId(String orderId);

    <T> T getOrderByOrderId(String orderId, Class<T> clazz);

    @Query("select * from demo_orders_tbl where succeed = true")
    List<DemoOrderRecord> getSucceedOrders();

    List<DemoOrderProjection> findDemoOrdersBySucceed(boolean succeed);

}
