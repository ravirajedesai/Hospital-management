package com.biscuitShop.Biscuit_order._service.repository;

import com.biscuitShop.Biscuit_order._service.entity.BiscuitOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiscuitOrderRepo extends JpaRepository<BiscuitOrder,Long> {

}
