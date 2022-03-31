package com.api.controledeestacionamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.controledeestacionamento.models.ParkingSpotModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParkingSpotRepository.
 */
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

	/**
	 * Exists by license plate car.
	 *
	 * @param licensePlateCar the license plate car
	 * @return true, if successful
	 */
	boolean existsByLicensePlateCar(String licensePlateCar);

	/**
	 * Exists by parcking spot number.
	 *
	 * @param parckingSpotNumber the parcking spot number
	 * @return true, if successful
	 */
	boolean existsByParckingSpotNumber(String parckingSpotNumber);

	/**
	 * Exists by apartment and block.
	 *
	 * @param apartment the apartment
	 * @param block the block
	 * @return true, if successful
	 */
	boolean existsByApartmentAndBlock(String apartment, String block);

}
