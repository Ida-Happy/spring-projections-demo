package com.example.demo.repo;

import com.example.demo.domain.DemoItem;
import com.example.demo.domain.projection.DemoItemOpenProjection;
import com.example.demo.domain.projection.DemoOrderTotalProjection;
import com.example.demo.domain.projection.DemoOrderTotalRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoItemRepository extends CrudRepository<DemoItem, Integer> {
    List<DemoItemOpenProjection> getItemsByOrderId(String orderId);

    @Query("select shop_url, count(shop_url) as total from demo_items_tbl group by shop_url")
    List<DemoOrderTotalRecord> getTotalGroupByShop();

    @Query("select shop_url, count(shop_url) as total from demo_items_tbl group by shop_url")
    List<DemoOrderTotalProjection> getTotalProjectionGroupByShop();
}
