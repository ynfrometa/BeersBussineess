package com.beersbussines.respositories;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.beersbussines.model.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer>{

	//List<Beer> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
	
	@Query("select u from Beer u where u.beername like %?1%")
	List<Beer> getBerByName(String beername);
	
	@Query("select u from Beer u where u.beername like ?1 and u.type like ?2")
	Optional<Beer> queryMultiple(String beername,String type);

}
