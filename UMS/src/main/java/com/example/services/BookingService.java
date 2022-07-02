package com.example.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.BookingRequestDTO;
import com.example.modal.BookingEntity;
import com.example.repository.BookingRepository;

public class BookingService {
	@Autowired BookingRepository bookingRepository;
	
	 //add booking
	   public BookingRequestDTO saveBooking(BookingRequestDTO bookingDTO) {
		   
		  BookingEntity objBookingEntity= bookingRepository.findBookingByID(bookingDTO.getId()); 
	         if(Objects.isNull(objBookingEntity)) { 
	        	 BookingEntity objBooking = new BookingEntity();
	        	 objBooking.setId(bookingDTO.getId());
	        	 objBooking.setBookingName(bookingDTO.getBookingName());
		         bookingRepository.save(objBooking);
	         }
	      return bookingDTO;
	   }
	   
	   public List<BookingRequestDTO> getListOfBookings(){
		   List<BookingEntity> lstBookings = bookingRepository.findAll();		   
		   List<BookingRequestDTO> lstBookingDTO= new ArrayList<>();
		   lstBookings.forEach((booking)->{
			   BookingRequestDTO bookingDTO = new BookingRequestDTO();
			   setModelToDTO(booking,bookingDTO);
			   lstBookingDTO.add(bookingDTO);
		   });
		   return lstBookingDTO;
	   }
	   
	   public BookingRequestDTO updateBooking(BookingRequestDTO bookingDTO) {
			  BookingEntity objBookingEntity= bookingRepository.findBookingByID(bookingDTO.getId()); 
		         if(Objects.nonNull(objBookingEntity)) {
		        	 BookingEntity objBooking = new BookingEntity();
		        	 setDTOToModel(bookingDTO,objBooking);
			         bookingRepository.save(objBooking);
		         }
		         return bookingDTO; 
	   }   
	   
	   //get booking details by bookingId
	   public BookingRequestDTO fetchBookingDetails(Long bookingId) {
		   BookingRequestDTO bookingDTO = null ;	      
		   BookingEntity objBookingEntity= bookingRepository.findBookingByID(bookingId);
	         if(Objects.nonNull(objBookingEntity)) {
	        	 bookingDTO = new BookingRequestDTO();
	            setModelToDTO(objBookingEntity, bookingDTO);
	         }
	      return bookingDTO;
	   }	   
	   
	   
	   private void setModelToDTO(BookingEntity booking, BookingRequestDTO bookingDTO) {
		   		bookingDTO.setBookingName(booking.getBookingName());
		   		bookingDTO.setId(booking.getId());
	   }
	   
	   private void setDTOToModel(BookingRequestDTO bookingDTO,BookingEntity booking) {
	   		booking.setBookingName(bookingDTO.getBookingName());
	   		booking.setId(bookingDTO.getId());
	   }	
	   

}
