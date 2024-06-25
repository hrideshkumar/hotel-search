package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.DTO.HotelDTO;
import com.hotel.entity.Hotel;
import com.hotel.repo.HotelRepo;
import com.hotel.util.Converter;

@Service
public class HotelService {

	@Autowired
	private HotelRepo repo;
	
	
	
	public HotelDTO createHotel(HotelDTO dto) {
		Hotel hotel = Converter.dtoToEntiHotel(dto);
		return Converter.entityTODTO(repo.save(hotel));
	}
	
	
}
