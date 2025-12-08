package com.hotelRating.ratingService.Service;

import com.hotelRating.ratingService.Entity.Ratings;

import java.util.List;

public interface ServiceRatings {
    Ratings create(Ratings ratings);
    List<Ratings>getRatings();
    List<Ratings>getRatingByUserId(String userId);
    List<Ratings>getRatingByHotelId(String hotelId);
}
