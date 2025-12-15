package com.biscuitShop.Biscuit_order._service.service;

import com.biscuitShop.Biscuit_order._service.dto.OrderRequest;
import com.biscuitShop.Biscuit_order._service.entity.BiscuitOrder;
import org.springframework.data.domain.Page;


public interface BiscuitOrderService {
    Page<BiscuitOrder> getAllOrders(int pageNo,
                                    int pageSize,
                                    String sortBy,
                                    String sortDir);
    BiscuitOrder getOrderById(Long id);
    void deleteOrderById(Long id);
    BiscuitOrder postBiscuitOrder(OrderRequest request);


}
