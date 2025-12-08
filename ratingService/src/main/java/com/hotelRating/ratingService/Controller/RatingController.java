package com.hotelRating.ratingService.Controller;

import com.hotelRating.ratingService.Entity.Ratings;
import com.hotelRating.ratingService.Service.ServiceRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private ServiceRatings serviceRatings;

    @PostMapping
    public ResponseEntity<Ratings>create(@RequestBody Ratings ratings){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceRatings.create(ratings));
    }
    @GetMapping
    public ResponseEntity<List<Ratings>>getAllRatings(){
        return ResponseEntity
                .ok(serviceRatings.getRatings());
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>>getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity
                .ok(serviceRatings.getRatingByUserId(userId));
    }
    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<Ratings>>getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity
                .ok(serviceRatings.getRatingByHotelId(hotelId));
    }
}
