package com.hotel.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RatingDTO {

	private int id;
	private int star;
	private String comment;
	private LocalDateTime date;
	
}
