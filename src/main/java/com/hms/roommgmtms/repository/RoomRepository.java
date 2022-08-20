package com.hms.roommgmtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.roommgmtms.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
