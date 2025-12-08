package com.hotelservice.hotelservice.impl;

import com.hotelservice.hotelservice.Entity.Hotel;
import com.hotelservice.hotelservice.Exceptions.ResourceNotFoundException;
import com.hotelservice.hotelservice.Repository.hotelRepo;
import com.hotelservice.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceImpl implements HotelService {
    @Autowired
    private hotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepo
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel With Given Id Not Found.."));
    }
}
