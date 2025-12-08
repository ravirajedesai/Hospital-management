package com.hotelservice.hotelservice.Service;

import com.hotelservice.hotelservice.Entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel>getAll();
    Hotel getById(String id);
}
