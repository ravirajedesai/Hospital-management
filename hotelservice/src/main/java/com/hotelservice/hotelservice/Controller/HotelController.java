package com.hotelservice.hotelservice.Controller;

import com.hotelservice.hotelservice.Entity.Hotel;
import com.hotelservice.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController{
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel>create(@RequestBody Hotel hotel){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelService.create(hotel));
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel>getHotelById(@PathVariable String hotelId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelService.getById(hotelId));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>>getAll(){
        return ResponseEntity
                .ok(hotelService.getAll());
    }
}
