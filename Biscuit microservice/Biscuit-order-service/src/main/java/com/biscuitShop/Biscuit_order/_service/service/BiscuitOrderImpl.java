package com.biscuitShop.Biscuit_order._service.service;

import com.biscuitShop.Biscuit_order._service.dto.BiscuitResponse;
import com.biscuitShop.Biscuit_order._service.dto.OrderRequest;
import com.biscuitShop.Biscuit_order._service.entity.BiscuitOrder;
import com.biscuitShop.Biscuit_order._service.exception.OrderNoFound;
import com.biscuitShop.Biscuit_order._service.feignClient.BiscuitClient;
import com.biscuitShop.Biscuit_order._service.repository.BiscuitOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BiscuitOrderImpl implements BiscuitOrderService{

    @Autowired
    BiscuitOrderRepo repo;

    @Autowired
    BiscuitClient client;

    @Override
    public Page<BiscuitOrder> getAllOrders(int pageNo,
                                           int pageSize,
                                           String sortBy,
                                           String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("DESC")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        PageRequest pageRequest =PageRequest.of(pageNo-1,pageSize,sort);
        return repo.findAll(pageRequest);
    }
    @Override
    public BiscuitOrder getOrderById(Long id) {
        return repo.findById(id)
                .orElseThrow(()-> new OrderNoFound("Order Not Found with Id: "+id));
    }
    @Override
    public void deleteOrderById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public BiscuitOrder postBiscuitOrder(OrderRequest request) {

        BiscuitResponse dto=client.getBiscuitByName(request.getBiscuitName());

        if(dto.getStock()< request.getQuantity()){
            throw new OrderNoFound("Insufficient Biscuit Stock");
        }
        BiscuitResponse updated=client
                .reduceBiscuitStock(dto.getBiscuitId(), request.getQuantity());

       BiscuitOrder order=new BiscuitOrder();
       order.setCustomerName(request.getCustomerName());
       order.setQuantity(request.getQuantity());
       order.setBiscuitId(dto.getBiscuitId());
       //order.setStock(updated.getStock());

        return repo.save(order);
    }

}
