package com.beersbussines.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.beersbussines.model.Beer;
import com.beersbussines.model.BeerInput;
import com.beersbussines.model.Manufacturer;
import com.beersbussines.respositories.BeerRepository;

@Service
public class BeerService {

	@Autowired
	BeerRepository beerRepository;

	public Optional<Beer> getByid2(@PathVariable Integer id) {
		return beerRepository.findById(id);
	}
	
	public List<Beer> allOriginal() {
		return (List<Beer>) beerRepository.findAll(Sort.by("beername"));
	}
	

	public void add(@RequestBody Beer newBeer) {
		beerRepository.save(newBeer);
	}

	public Optional<Beer> getByid(@PathVariable Integer id) {
		return beerRepository.findById(id);

	}

	public void delete(@PathVariable Integer id) {
		beerRepository.deleteById(id);
	}

	public Beer update(@RequestBody Beer newBeer) {
		return beerRepository.save(newBeer);
	}

	public Beer addbeers(@RequestBody BeerInput newBeer) {
		Beer beer = new Beer();
		beer.setBeer_id(newBeer.getBeer_id());
		beer.setBeername(newBeer.getBeername());
		beer.setDescription(newBeer.getDescription());
		beer.setGraduation(newBeer.getGraduation());
		beer.setType(newBeer.getType());
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setManufacturer_id(newBeer.getManufacturer_id());
		beer.setManufacturer(manufacturer);
		return beerRepository.save(beer);
	}

	public List<Beer> getBerByName(@PathVariable String nameBeer) {
		return beerRepository.getBerByName(nameBeer);
	}
	
	public Optional<Beer> queryMultiple(@RequestParam (required = false) String beerName,@RequestParam (required = false) String type) {	
		return beerRepository.queryMultiple(beerName, type);
	}

}
