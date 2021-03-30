package com.beersbussines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.beersbussines.model.Beer;
import com.beersbussines.model.Manufacturer;
import com.beersbussines.respositories.ManufacturerRepository;

@Service
public class ManufacturerService {
	@Autowired
	ManufacturerRepository manufacturerRepository;

	public Manufacturer add(@RequestBody Manufacturer newManufacturer) {
		return manufacturerRepository.save(newManufacturer);
	}

	public List<Manufacturer> getAll() {
		return manufacturerRepository.findAll();
	}

	public Optional<Manufacturer> getById(@PathVariable Integer id) {
		return manufacturerRepository.findById(id);
	}

	public void deleteById(@PathVariable Integer id) {
		manufacturerRepository.deleteById(id);
	}

	public Manufacturer update(@RequestBody Manufacturer newManufacturer) {
		return manufacturerRepository.save(newManufacturer);
	}

}
