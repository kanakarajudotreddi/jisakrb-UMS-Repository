package com.example.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookingEntity {
	//@Id @GeneratedValue
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
