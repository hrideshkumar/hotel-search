package com.hotel.util;

import java.util.List;

import com.hotel.DTO.HotelDTO;
import com.hotel.DTO.HotelDetailsDTO;
import com.hotel.DTO.RatingDTO;
import com.hotel.entity.Hotel;


public class Converter {

	public static HotelDTO entityTODTO(Hotel hotel) {
		HotelDTO dto = new HotelDTO();
		dto.setId(hotel.getId());
		dto.setName(hotel.getName());
		dto.setCreatedDate(hotel.getCreatedDate());
		dto.setUpdatedDate(hotel.getUpdatedDate());
		dto.setLocation(hotel.getLocation());
		return dto;
	}
	
	public static Hotel dtoToEntiHotel(HotelDTO dto) {
		Hotel entity = new Hotel();
		entity.setName(dto.getName());
		entity.setLocation(dto.getLocation());
		return entity;
	}
	
	public static HotelDetailsDTO hotelWithRatings(HotelDTO hotel, List<RatingDTO> ratings) {
		return new HotelDetailsDTO(hotel.getId(), hotel.getName(), hotel.getLocation(), hotel.getCreatedDate(), hotel.getUpdatedDate(), ratings);
	}
}
