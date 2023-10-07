package com.nst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nst.Entity.Restaurent;
import com.nst.Service.RestaurantService;

@Controller
public class RestaurantController {

	
	private RestaurantService restaurantService;

	@Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/search")
    public List<Restaurent> searchRestaurants(@RequestParam String keyword) {
        return restaurantService.searchRestaurants(keyword);
    }
    
    @RequestMapping("/map")
    public String map()
    {
    	return "map";
    }
    
    @RequestMapping("/restaurents")
    public String restaurnets()
    {
    	return "restaurents";
    }
    
    @RequestMapping("/all_Restaurents")
    public String All_restaurnets()
    {
    	return "all_Restaurents";
    }
    
    @RequestMapping("/all_cafes")
    public String All_Cafes()
    {
    	return "all_cafes";
    }
    
    
}
