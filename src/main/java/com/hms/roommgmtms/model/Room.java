package com.hms.roommgmtms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roomId;
	
	@Column(nullable = false)
	private String roomType;

	@Column(nullable = false)
	private LocalDate checkIn;
	
	
	@Column(nullable = false)
	private LocalDate checkOut;


	
	

	public Room(Long roomId, String roomType, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}




	public Long getRoomId() {
		return roomId;
	}




	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public LocalDate getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
}
