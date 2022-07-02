package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modal.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{
	BookingEntity  findByBookingName(@RequestParam String bookingName);
	
	BookingEntity findBookingByID(@RequestParam Long id);
}
