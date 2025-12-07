package com.microservices.user.service.userservice.Impl;

import com.microservices.user.service.userservice.Entites.Hotel;
import com.microservices.user.service.userservice.Entites.Rating;
import com.microservices.user.service.userservice.Entites.User;
import com.microservices.user.service.userservice.External.services.HotelServices;
import com.microservices.user.service.userservice.Repository.UserRepository;
import com.microservices.user.service.userservice.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found With Given Id" + userId));

        Rating[] ratingOfUser=restTemplate
                .getForObject("http://RATING-SERVICE/ratings/users/"+ user.getUserId()
                        ,Rating[].class);

        logger.info("Ratings fetched for user {} -> {}", userId, Arrays.toString(ratingOfUser));

        List<Rating>ratings= Arrays.stream(ratingOfUser).collect(Collectors.toList());

        List<Rating>ratingList=ratings.stream().map(rating->{

           // ResponseEntity<Hotel>response=restTemplate.getForEntity(
          //          "http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            Hotel hotel=hotelServices.getHotel(rating.getHotelId());

           // logger.info("Hotel fetched for rating {} -> {}", rating.getRatingId(), hotel);
            rating.setHotel(hotel);

            return rating;

        }).collect(Collectors.toList());
        user.setRatings(ratingList);

        return user;
    }
}
