package com.nst.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nst.Entity.Restaurent;

public interface RestaurentRepository extends JpaRepository<Restaurent, Integer> {

	List<Restaurent> findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase(String name, String cuisine);
	
}
