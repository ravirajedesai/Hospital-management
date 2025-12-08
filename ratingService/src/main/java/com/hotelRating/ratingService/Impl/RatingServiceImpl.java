package com.hotelRating.ratingService.Impl;

import com.hotelRating.ratingService.Entity.Ratings;
import com.hotelRating.ratingService.Repository.RatingRepo;
import com.hotelRating.ratingService.Service.ServiceRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements ServiceRatings {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Ratings create(Ratings ratings) {
        return ratingRepo.save(ratings);
    }

    @Override
    public List<Ratings> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Ratings> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
