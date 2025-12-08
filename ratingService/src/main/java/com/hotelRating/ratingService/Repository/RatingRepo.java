package com.hotelRating.ratingService.Repository;

import com.hotelRating.ratingService.Entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Ratings,String> {
    List<Ratings>findByUserId(String userId);
    List<Ratings>findByHotelId(String hotelId);

}
