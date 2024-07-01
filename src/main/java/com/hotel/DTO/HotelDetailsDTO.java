package com.hotel.DTO;



import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class HotelDetailsDTO extends HotelDTO{

	private List<RatingDTO> ratings;
	
	public HotelDetailsDTO(int hotelId, String name, String location, LocalDateTime  createdDate, LocalDateTime  updatedDate, List<RatingDTO> ratings) {
		super(hotelId, name, location, createdDate, updatedDate);
		this.ratings = ratings;
	}
	
}
