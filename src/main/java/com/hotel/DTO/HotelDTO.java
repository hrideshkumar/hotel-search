package com.hotel.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HotelDTO {
	
	private int id;
	private String name;
	private String location;
	private LocalDateTime  createdDate;
	private LocalDateTime  updatedDate;

}
