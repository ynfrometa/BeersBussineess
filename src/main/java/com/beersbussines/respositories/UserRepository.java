package com.beersbussines.respositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.beersbussines.model.Beer;
import com.beersbussines.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUser(String user);

}
