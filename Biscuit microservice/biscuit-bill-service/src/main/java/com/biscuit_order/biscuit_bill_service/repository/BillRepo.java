package com.biscuit_order.biscuit_bill_service.repository;

import com.biscuit_order.biscuit_bill_service.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {
}
