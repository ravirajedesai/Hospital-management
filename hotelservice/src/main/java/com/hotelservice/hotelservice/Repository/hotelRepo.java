package com.hotelservice.hotelservice.Repository;

import com.hotelservice.hotelservice.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface hotelRepo extends JpaRepository<Hotel,String> {
}
