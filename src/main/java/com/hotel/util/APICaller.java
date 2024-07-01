package com.hotel.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.hotel.DTO.RatingDTO;

@Component
public class APICaller {

	
	@Autowired
	private RestTemplate client;
	
	
	public List<RatingDTO> getHotelRating(int hotelId){
		//final ObjectMapper mapper = new JsonMapper();
		
		String url = "http://localhost:8082/api/v1/rating?hotelId="+hotelId;
		ResponseEntity<RatingDTO[]> response = client.getForEntity(url, RatingDTO[].class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return Arrays.asList(response.getBody());
			
		}
		return new ArrayList<RatingDTO>();
	} 
}
