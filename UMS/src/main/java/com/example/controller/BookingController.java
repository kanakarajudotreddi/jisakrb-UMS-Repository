package com.example.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookingRequestDTO;
import com.example.modal.BookingEntity;
import com.example.repository.BookingRepository;
import com.example.services.BookingService;

@RestController
public class BookingController {
	@RequestMapping("/bookings")
	Collection<BookingEntity> bookings(){
		return this.bookingRepository.findAll();
	}
	
	   @PostMapping("/saveBookingr")
	   public ResponseEntity<BookingRequestDTO> createBooking(@RequestBody BookingRequestDTO bookingDTO){
	      return Optional.ofNullable(bookingService.saveBooking(bookingDTO))
	            .map(booking -> new ResponseEntity<>(booking,HttpStatus.CREATED))
	            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	   }
	   @GetMapping("/getListOfBooking")
	   public ResponseEntity<List<BookingRequestDTO>>  getListOfBookings(){
		      return Optional.ofNullable(bookingService.getListOfBookings())
		              .map(booking -> new ResponseEntity<>(booking , HttpStatus.OK))
		              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));	   
	   }
	   
	   @PutMapping("/updateBooking")
	   public ResponseEntity<BookingRequestDTO> updateBooking(@RequestBody BookingRequestDTO bookingDTO){
	      return Optional.ofNullable(bookingService.updateBooking(bookingDTO))
	            .map(booking -> new ResponseEntity<>(booking,HttpStatus.CREATED))
	            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	   }	
	   
	   @GetMapping("/getUser/{bookingID}")
	   public ResponseEntity<BookingRequestDTO> getUserDeatils(@PathVariable Long bookingID){
	      return Optional.ofNullable(bookingService.fetchBookingDetails(bookingID))
	            .map(booking -> new ResponseEntity<>(booking,HttpStatus.OK))
	            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	   }
	
	
	@Autowired BookingRepository bookingRepository;
	@Autowired BookingService bookingService;
}
