package com.hotel.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelDTO {
	
	private int id;
	private String name;
	private String location;
	private LocalDateTime  createdDate;
	private LocalDateTime  updatedDate;

}
