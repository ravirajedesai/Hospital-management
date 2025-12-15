package com.buscuitShop.biscuit_service.repository;

import com.buscuitShop.biscuit_service.entity.Biscuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiscuitRepo extends JpaRepository<Biscuit,Long> {

    Optional<Biscuit>findByBiscuitName(String biscuitName);
}
