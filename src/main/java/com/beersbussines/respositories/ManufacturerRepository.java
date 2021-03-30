package com.beersbussines.respositories;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.beersbussines.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

	default int text() {
		return 10;
	}
	
}
