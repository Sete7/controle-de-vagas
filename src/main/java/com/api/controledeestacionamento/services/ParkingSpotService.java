package com.api.controledeestacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.controledeestacionamento.dto.ParkingSpotDto;
import com.api.controledeestacionamento.models.ParkingSpotModel;
import com.api.controledeestacionamento.repository.ParkingSpotRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingSpotService.
 */
@Service
public class ParkingSpotService {

/** The parking spot repository. */
//	@Autowired
	final ParkingSpotRepository parkingSpotRepository;

	/**
	 * Instantiates a new parking spot service.
	 *
	 * @param parkingSpotRepository the parking spot repository
	 */
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		super();
		this.parkingSpotRepository = parkingSpotRepository;
	}

	/**
	 * Save.
	 *
	 * @param parkingSpotModel the parking spot model
	 * @return the parking spot model
	 */
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);
	}

	/**
	 * Exists by license plate car.
	 *
	 * @param licensePlateCar the license plate car
	 * @return true, if successful
	 */
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	/**
	 * Exists by parcking spot number.
	 *
	 * @param parckingSpotNumber the parcking spot number
	 * @return true, if successful
	 */
	public boolean existsByParckingSpotNumber(String parckingSpotNumber) {
		return parkingSpotRepository.existsByParckingSpotNumber(parckingSpotNumber);
	}

	/**
	 * Exists by apartment and block.
	 *
	 * @param apartment the apartment
	 * @param block the block
	 * @return true, if successful
	 */
	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}

	/**
	 * Find all page.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<ParkingSpotModel> findAllPage(Pageable pageable) {
		return parkingSpotRepository.findAll(pageable);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}

	/**
	 * Delete.
	 *
	 * @param parkingSpotModel the parking spot model
	 */
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}

}
