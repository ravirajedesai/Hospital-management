package com.biscuit_order.biscuit_bill_service.service;

import com.biscuit_order.biscuit_bill_service.dto.BillRequest;
import com.biscuit_order.biscuit_bill_service.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    void deleteBillById(Long id);
    Bill addBill(Bill bill);

    Bill createBill(BillRequest request);
}
