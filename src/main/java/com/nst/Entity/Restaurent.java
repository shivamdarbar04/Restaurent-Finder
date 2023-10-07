package com.nst.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurent {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String cuisine;
	    private String address;
		
	    public Restaurent(Long id, String name, String cuisine, String address) {
			this.id = id;
			this.name = name;
			this.cuisine = cuisine;
			this.address = address;
		}

		public Restaurent() {
		// TODO Auto-generated constructor stub
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCuisine() {
			return cuisine;
		}

		public void setCuisine(String cuisine) {
			this.cuisine = cuisine;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Restaurent [id=" + id + ", name=" + name + ", cuisine=" + cuisine + ", address=" + address + "]";
		}
	    
	    
	    

}
