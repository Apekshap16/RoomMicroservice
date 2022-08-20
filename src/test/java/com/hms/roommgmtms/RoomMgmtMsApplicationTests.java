package com.hms.roommgmtms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hms.roommgmtms.model.Room;
import com.hms.roommgmtms.repository.RoomRepository;

@SpringBootTest
class RoomMgmtMsApplicationTests {
    /*
	@Test
	void contextLoads() {
	}*/
    @Autowired
	private RoomRepository roomRepository;
    
	@Test
	public void testpostRoom() {
	    Room room = new Room();    
	    room.setRoomId(5L);
	    room.setRoomType("Single");
	    room.setCheckIn(LocalDate.now());
	    room.setCheckOut(LocalDate.now());
	    roomRepository.save(room);
	    assertNotNull(roomRepository.findById(5L).get());
	    
	}
	
	@Test
	public void testgetRooms() {
		List<Room> list = roomRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testgetRoomById() {
		Room room = roomRepository.findById(5L).get();
		assertEquals("Single", room.getRoomType());
		assertEquals(LocalDate.of(2022,8,20), room.getCheckIn());
		assertEquals(LocalDate.of(2022,8,20), room.getCheckOut());
	}
	
	@Test
	public void testdeleteCourse() {
		roomRepository.deleteById(6L);
		assertThat(roomRepository.existsById(6L)).isFalse();//always check id to delete it
	}
	
	@Test
	public void testupdateRoomDetails() {
		Room room = roomRepository.findById(2L).get();
		room.setRoomType("Double");
		//room.setCheckIn(LocalDate.of(2022, 05, 11));
		//room.setCheckOut(LocalDate.of(2022, 05, 12));
		roomRepository.save(room);
		assertNotEquals("Triple", roomRepository.findById(2L).get().getRoomType());
	}
	
}
