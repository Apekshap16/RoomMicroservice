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
import io.swagger.annotations.ApiOperation;

@RestController
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	// Add room --Create a new room
	@ApiOperation( value = "Post the room",
			       response = Room.class)
	@PostMapping("/room")
	public Room postRoom(@RequestBody Room room) {
		return roomRepository.save(room);
	}

	// Get all Rooms--Read
	@ApiOperation(value = "Fetch all the rooms",
			      response = Room.class)
	@GetMapping("/room")
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}

	// Get Room record by id--Read *****************Use it*********remain to test on postman
	@ApiOperation(value = "Fetch room by room id",
			      notes = "Provide an id of the room and fetch the room details",
			      response = Room.class)
	@GetMapping("/room/{roomId}")
	public Optional<Room> getRoomById(@PathVariable("roomId") Long roomId) {
		return roomRepository.findById(roomId);
	}

	// delete room by id --Delete
	@ApiOperation(value = "Delete room by room id",
			      notes = "Provide an id of the room and delete the room details",
			      response = Room.class)
	@DeleteMapping("/room/{roomId}")
	public void deleteRoomById(@PathVariable("roomId") Long roomId) {
		roomRepository.deleteById(roomId);
	}

	// Update room by using roomId --Update
	@ApiOperation(value = "Update room by room id", 
			      notes = "Provide an id of the room and update the room details", 
			      response = Room.class)
	@PutMapping("/room/update/{roomId}")
	public Room updateRoomDetails(@PathVariable("roomId") Long roomId, @RequestBody Room roomNew) {
		
		// read room details from db by using roomId
		Room roomDB = roomRepository.getById(roomId);

		// Checking each value which is going to update whether is NULL or not
		if (roomNew.getRoomType() != null)
			roomDB.setRoomType(roomNew.getRoomType()); // If value is not NULL then update it
		if (roomNew.getCheckIn() != null)
			roomDB.setCheckIn(roomNew.getCheckIn());
		if (roomNew.getCheckOut() != null)
			roomDB.setCheckOut(roomNew.getCheckOut());

		// After save updated values in db
		return roomRepository.save(roomDB);

	}

}
