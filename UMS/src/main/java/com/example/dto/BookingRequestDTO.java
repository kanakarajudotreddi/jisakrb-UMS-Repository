package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class BookingRequestDTO {
	private Long id;
	private String bookingName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookingName() {
		return bookingName;
	}
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	
}
