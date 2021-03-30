package com.beersbussines;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.beersbussines.model.Beer;
import com.beersbussines.model.Manufacturer;
import com.beersbussines.model.User;
import com.beersbussines.respositories.BeerRepository;
import com.beersbussines.respositories.UserRepository;

@SpringBootTest
class BeersBussineessApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	BeerRepository beerRepository;

	@Test
	void createUser() {
		User user = new User();
		user.setUser("AdminPrueba");
		user.setPassword(passwordEncoder.encode("1234"));
		User userCreated = userRepository.save(user);
		assertTrue(userCreated.getUser().equals(user.getUser()));
	}

	@Test
	void getBeerById() {
		Beer beerGet = beerRepository.getOne(12);
		assertTrue(beerGet.getBeer_id() == 12);
	}

	@Test
	void addBeer() {
		Beer beer = new Beer();
		beer.setBeername("CervezaPrueba3");
		beer.setDescription("Descripion Prueba");
		beer.setGraduation("1.2");
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setManufacturer_id(1);
		manufacturer.setManufacturername("ManufacturerPrueba");
		beer.setManufacturer(manufacturer);
		beerRepository.save(beer);

		List<Beer> beerGet = beerRepository.getBerByName(beer.getBeername());
		assertTrue(beerGet.get(0).getBeername().equals(beer.getBeername()));
	}

	@Test
	void getBeerByBeerName() {
		List<Beer> beerGet = beerRepository.getBerByName("yoanni");
		assertTrue(beerGet.size() > 0);
	}

	@Test
	void deleteBeerName() {
		List<Beer> beerGet = beerRepository.getBerByName("CervezaPrueba3");

		if (beerGet.size() > 0) {

			for (int i = 0; i < beerGet.size(); i++) {
				beerRepository.deleteById(beerGet.get(i).getBeer_id());
			}
		}

		List<Beer> beerGet2 = beerRepository.getBerByName("CervezaPrueba3");
		assertTrue(beerGet2.size() == 0);
	}

	@Test
	void deleteUser() {
		User user = (User) userRepository.findByUser("AdminPrueba");
		userRepository.deleteById(user.getUser_id());

	}
}