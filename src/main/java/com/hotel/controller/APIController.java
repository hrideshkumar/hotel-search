package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.DTO.HotelDTO;
import com.hotel.service.HotelService;

@RestController
@RequestMapping(value = "/v1/api/hotel")
public class APIController {
	
	@Autowired
	private HotelService service;
	
	
	@PostMapping
	public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO request) {
		HotelDTO response = service.createHotel(request);
		return new ResponseEntity<HotelDTO>(response, HttpStatus.CREATED);
	}
	
	//name
	
	//location
	
	//name + location
	

}
