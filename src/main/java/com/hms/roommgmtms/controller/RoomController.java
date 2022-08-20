package com.hms.roommgmtms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.roommgmtms.model.Room;
import com.hms.roommgmtms.repository.RoomRepository;


@RestController
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/roomhello")
	public String getHello(){
		return "Hello World5";
	}
	
	//Add room --Create
	@PostMapping("/room")
	public Room postRoom(@RequestBody Room room)
	{
		return roomRepository.save(room);
		
	}
	
	//Get all Rooms--Read
	@GetMapping("/room")
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}
	
	//Get Room by id--Read *****************Use it*********remain to test on postman
		@GetMapping("/room/{roomId}")
		public Room getRoomById(@PathVariable("roomId") Long roomId) {
			return roomRepository.findById(roomId).get();
		}
	
	
	//delete room by id	--Delete
	@DeleteMapping("/room/{roomId}")		
	public void deleteCourse(@PathVariable("roomId") Long roomId) {
			roomRepository.deleteById(roomId);
	}
	
	
	//Update room by using roomId --Update
	@PutMapping("/room/update/{roomId}")
	public Room updateRoomDetails(@PathVariable("roomId") Long roomId,@RequestBody Room roomNew)
	{
	
		Room roomDB = roomRepository.getById(roomId);
			
		
		if(roomNew.getRoomType() != null)
			roomDB.setRoomType(roomNew.getRoomType());
		if(roomNew.getCheckIn() != null)
			roomDB.setCheckIn(roomNew.getCheckIn());
		if(roomNew.getCheckOut() != null)
			roomDB.setCheckOut(roomNew.getCheckOut());
		
		
		return roomRepository.save(roomDB);
	
	}

}
