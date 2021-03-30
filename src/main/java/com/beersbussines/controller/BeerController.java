package com.beersbussines.controller;

import java.awt.print.Pageable;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beersbussines.model.Beer;
import com.beersbussines.model.BeerInput;
import com.beersbussines.model.Manufacturer;
import com.beersbussines.respositories.BeerRepository;
import com.beersbussines.service.BeerService;

@RestController
@RequestMapping("/beer")
public class BeerController {

	@Autowired
	BeerService beerService;

	@GetMapping("{id}")
	public Optional<Beer> getByid2(@PathVariable Integer id) {
		return beerService.getByid2(id);
	}

	@GetMapping("/v2")
	public List<Beer> getBerByName(@RequestParam String beerName) {
		return beerService.getBerByName(beerName);
	}

	@GetMapping("/v1")
	public List<Beer> allOriginal() {
		return beerService.allOriginal();
	}

	@PostMapping()
	public void add(@RequestBody BeerInput newBeer) {
		beerService.addbeers(newBeer);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		beerService.delete(id);
	}

	@PutMapping
	public Beer update(@RequestBody Beer newBeer) {
		return beerService.update(newBeer);
	}

}
