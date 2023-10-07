package com.nst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nst.Entity.Restaurent;
import com.nst.Repository.RestaurentRepository;

@Service
public class RestaurantService {

	
	private RestaurentRepository repository;

 
	@Autowired
    public RestaurantService(RestaurentRepository restaurantRepository) {
        this.repository = restaurantRepository;
    }

    public List<Restaurent> searchRestaurants(String keyword) {
        return repository.findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase(keyword, keyword);
    }
}
