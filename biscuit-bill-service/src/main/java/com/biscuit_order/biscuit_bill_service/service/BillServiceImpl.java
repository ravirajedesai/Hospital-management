package com.biscuit_order.biscuit_bill_service.service;

import com.biscuit_order.biscuit_bill_service.dto.BillRequest;
import com.biscuit_order.biscuit_bill_service.dto.BiscuitDto;
import com.biscuit_order.biscuit_bill_service.dto.OrderDto;
import com.biscuit_order.biscuit_bill_service.entity.Bill;
import com.biscuit_order.biscuit_bill_service.feign.BiscuitClient;
import com.biscuit_order.biscuit_bill_service.feign.OrderClient;
import com.biscuit_order.biscuit_bill_service.repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepo repo;

    @Autowired
    BiscuitClient biscuitClient;

    @Autowired
    OrderClient orderClient;

    @Override
    public List<Bill> getAllBills() {
        List<Bill> getAll=repo.findAll();
        return getAll;
    }
    @Override
    public Bill getBillById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new RuntimeException("Bill Not Found.."));
    }
    @Override
    public void deleteBillById(Long id) {
        repo.deleteById(id);
    }
    @Override
    public Bill addBill(Bill bill) {
        return repo.save(bill);
    }

    @Override
    public Bill createBill(BillRequest request) {

        OrderDto orderDto=orderClient.getOrderById(request.getOrderId());
        BiscuitDto biscuitDto = biscuitClient.getBiscuitById(orderDto.getBiscuitId());

        Bill bill= new Bill();
        bill.setOrderId(orderDto.getOrderId());
        bill.setQuantity(orderDto.getQuantity());
        bill.setBiscuitId(orderDto.getBiscuitId());
        bill.setCustomerName(orderDto.getCustomerName());
        bill.setRate(biscuitDto.getRate());
        bill.setTotalAmount(orderDto.getQuantity() * biscuitDto.getRate());
        return repo.save(bill);
    }
}
