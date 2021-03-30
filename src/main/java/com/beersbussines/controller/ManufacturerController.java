package com.beersbussines.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beersbussines.model.Beer;
import com.beersbussines.model.Manufacturer;
import com.beersbussines.respositories.ManufacturerRepository;
import com.beersbussines.service.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;

	@GetMapping()
	public List<Manufacturer> all() {
		return manufacturerService.getAll();
	}

	@GetMapping("{id}")
	public Optional<Manufacturer> getById(@PathVariable Integer id) {
		return manufacturerService.getById(id);
	}

	@PostMapping()
	public Manufacturer add(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.add(manufacturer);
	}

	@PutMapping()
	public Manufacturer update(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.add(manufacturer);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		manufacturerService.deleteById(id);
	}

}
