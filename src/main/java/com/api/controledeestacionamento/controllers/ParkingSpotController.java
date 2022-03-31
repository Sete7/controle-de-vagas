package com.api.controledeestacionamento.controllers;

import com.api.controledeestacionamento.dto.ParkingSpotDto;
import com.api.controledeestacionamento.models.ParkingSpotModel;
import com.api.controledeestacionamento.services.ParkingSpotService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingSpotController.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	/** The parking spot service. */
	final ParkingSpotService parkingSpotService;

	/**
	 * Instantiates a new parking spot controller.
	 *
	 * @param parkingSpotService the parking spot service
	 */
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}

/**
 * Save.
 *
 * @param parkingSpotDto the parking spot dto
 * @return the response entity
 */
//	Metodo Salvar
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
//		validation
		if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflito: Já existe uma placa registrada para está vaga.");
		}

		if (parkingSpotService.existsByParckingSpotNumber(parkingSpotDto.getParckingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já se encontra em uso.");
		}

		if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflito:  Vaga já está registrada para um apartamento e ou bloco");
		}

		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}

/**
 * Gets the all parking spot.
 *
 * @return the all parking spot
 */
//	Metodo listar
	@GetMapping
	public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpot() {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
	}

/**
 * Gets the all parking spots page.
 *
 * @param pageable the pageable
 * @return the all parking spots page
 */
//	Metodo listar por paginação
	@GetMapping(value = "/pageable-parking")
	public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpotsPage(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAllPage(pageable));
	}

/**
 * Gets the one parking spot.
 *
 * @param id the id
 * @return the one parking spot
 */
//	Metodo retornar pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
//		verifica se existe vaga pelo id
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if (!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
		}
//		após verificado é retornado a vaga com sucesso
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}

/**
 * Delete parking spot.
 *
 * @param id the id
 * @return the response entity
 */
//	Metodo delata pelo id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {

//		verifica se existe vaga pelo id
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if (!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
		}
//		após verificada e existindo vaga ele é deletado
		parkingSpotService.delete(parkingSpotModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Vaga deletada com sucesso!");
	}

	/**
	 * Update parking spot.
	 *
	 * @param id the id
	 * @param parkingSpotDto the parking spot dto
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if (!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
		}
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
		parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
	}

}
