package com.hms.roommgmtms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class RoomMgmtMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomMgmtMsApplication.class, args);
	}

}
