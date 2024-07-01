package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.DTO.HotelDTO;
import com.hotel.DTO.HotelDetailsDTO;
import com.hotel.DTO.RatingDTO;
import com.hotel.entity.Hotel;
import com.hotel.repo.HotelRepo;
import com.hotel.util.APICaller;
import com.hotel.util.Converter;

@Service
public class HotelService {

	@Autowired
	private HotelRepo repo;
	
	@Autowired
	private APICaller caller;
	
	public HotelDTO createHotel(HotelDTO dto) {
		Hotel hotel = Converter.dtoToEntiHotel(dto);
		return Converter.entityTODTO(repo.save(hotel));
	}
	
	public List<HotelDTO> getAllHotel(){
		List<Hotel> hotels = repo.findAll();
		return hotels.stream().map(Converter::entityTODTO).collect(Collectors.toList());
	}
	
	public HotelDTO getHotelById(int id) {
		Hotel hotel = repo.getById(id);
		return Converter.entityTODTO(hotel);
	}
	
	public HotelDetailsDTO getHotelRatings(int hotelId){
		
		List<RatingDTO> ratings = caller.getHotelRating(hotelId);
		HotelDTO hotelDTO = getHotelById(hotelId);
		return Converter.hotelWithRatings(hotelDTO, ratings);
	}
	
	
}
