package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.DTO.HotelDTO;
import com.hotel.DTO.HotelDetailsDTO;
import com.hotel.DTO.RatingDTO;
import com.hotel.service.HotelService;
import com.hotel.util.Converter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/api/v1/hotel")
public class APIController {
	
	@Autowired
	private HotelService service;
	
	
	@PostMapping
	public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO request) {
		HotelDTO response = service.createHotel(request);
		return new ResponseEntity<HotelDTO>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<HotelDTO>> getAllHotels(){
		return new ResponseEntity<List<HotelDTO>>(service.getAllHotel(), HttpStatus.OK);
	}
	
	@GetMapping("/ratings/{hotelId}")
	@CircuitBreaker(name = "ratingServiceBreaker", fallbackMethod = "fallBackRatingService")
	public ResponseEntity<HotelDetailsDTO> getHotelRatings(@PathVariable int hotelId){
		HotelDetailsDTO dto = service.getHotelRatings(hotelId);
		return new ResponseEntity<HotelDetailsDTO>(dto, HttpStatus.OK);
	}
	
	
	public ResponseEntity<HotelDetailsDTO> fallBackRatingService(int hotelId, Exception ex){
		System.out.println("RatingService - Unavailable");
		ex.printStackTrace();
		HotelDTO hotelDTO = service.getHotelById(hotelId);
		HotelDetailsDTO response = Converter.hotelWithRatings(hotelDTO, null);
		return new ResponseEntity<HotelDetailsDTO>(response, HttpStatus.OK);
	}
	//name
	
	//location
	
	//name + location
	

}
