package com.hms.roommgmtms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.hms.roommgmtms.model.UserEntity;
import com.hms.roommgmtms.repository.UserEntityRepository;

//custom users are creating to use this spring security so r implementing userdetailsservice over here
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserEntityRepository userEntityRepository;
	
	
	// custome userservice userdetailsservice from spring security
	 @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

	        //Logic to get the user form the Database
		 Optional<UserEntity> user = userEntityRepository.findById(userName);		//here we will go with daatabase and search for the user with userID. and here findById is going to return an optional user so we mentioned optional here
		 
	     if(user.isPresent()){			//checking if user exists. then only we can go ahead and create user object & return back to the spring security
	            List<SimpleGrantedAuthority> authorities = new ArrayList<>();		// for the roles we are creating a list of simple granted authorities. and here we give the name the list as authorities 
	            Arrays.asList(user.get().getRole().split(",")).stream().forEach(authority ->	// here we split the roles and we r converting the array into a list so that we can use stream api to create a list of simple granted authority
	                authorities.add(new SimpleGrantedAuthority(authority))						//here for each authority we add  each authority to list of simple granted authority
	            );
	            return new User(user.get().getUsername(), user.get().getPassword(), authorities);		//list of authorities ready so here we  will create the object of user that we will pass our username
	        }else {
	            throw new UsernameNotFoundException("User " + userName + " does not exist...");
	        }
		 
		 
		 
		 
		 //return new User("admin","password",new ArrayList<>());   //arraylist used for role
}
	
}
