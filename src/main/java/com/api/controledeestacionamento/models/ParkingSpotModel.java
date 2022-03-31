package com.api.controledeestacionamento.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingSpotModel.
 */
@Entity
@Table(name = "tb_parcking_spot")
public class ParkingSpotModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	/** The parcking spot number. */
	@Column(nullable = false, unique = true, length = 10)
	private String parckingSpotNumber;
	
	/** The license plate car. */
	@Column(nullable = false, unique = true, length = 7)
	private String licensePlateCar;
	
	/** The brand car. */
	@Column(nullable = false, length = 70)
	private String brandCar;
	
	/** The model car. */
	@Column(nullable = false, length = 70)
	private String modelCar;
	
	/** The color car. */
	@Column(nullable = false, length = 70)
	private String colorCar;
	
	/** The registration date. */
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	
	/** The responsible name. */
	@Column(nullable = false, length = 130)
	private String responsibleName;
	
	/** The apartment. */
	@Column(nullable = false, length = 30)
	private String apartment;
	
	/** The block. */
	@Column(nullable = false, length = 30)
	private String block;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Gets the parcking spot number.
	 *
	 * @return the parcking spot number
	 */
	public String getParckingSpotNumber() {
		return parckingSpotNumber;
	}

	/**
	 * Sets the parcking spot number.
	 *
	 * @param parckingSpotNumber the new parcking spot number
	 */
	public void setParckingSpotNumber(String parckingSpotNumber) {
		this.parckingSpotNumber = parckingSpotNumber;
	}

	/**
	 * Gets the license plate car.
	 *
	 * @return the license plate car
	 */
	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	/**
	 * Sets the license plate car.
	 *
	 * @param licensePlateCar the new license plate car
	 */
	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}

	/**
	 * Gets the brand car.
	 *
	 * @return the brand car
	 */
	public String getBrandCar() {
		return brandCar;
	}

	/**
	 * Sets the brand car.
	 *
	 * @param brandCar the new brand car
	 */
	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	/**
	 * Gets the model car.
	 *
	 * @return the model car
	 */
	public String getModelCar() {
		return modelCar;
	}

	/**
	 * Sets the model car.
	 *
	 * @param modelCar the new model car
	 */
	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	/**
	 * Gets the color car.
	 *
	 * @return the color car
	 */
	public String getColorCar() {
		return colorCar;
	}

	/**
	 * Sets the color car.
	 *
	 * @param colorCar the new color car
	 */
	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	/**
	 * Gets the registration date.
	 *
	 * @return the registration date
	 */
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Sets the registration date.
	 *
	 * @param registrationDate the new registration date
	 */
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Gets the responsible name.
	 *
	 * @return the responsible name
	 */
	public String getResponsibleName() {
		return responsibleName;
	}

	/**
	 * Sets the responsible name.
	 *
	 * @param responsibleName the new responsible name
	 */
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	/**
	 * Gets the apartment.
	 *
	 * @return the apartment
	 */
	public String getApartment() {
		return apartment;
	}

	/**
	 * Sets the apartment.
	 *
	 * @param apartment the new apartment
	 */
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	/**
	 * Gets the block.
	 *
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * Sets the block.
	 *
	 * @param block the new block
	 */
	public void setBlock(String block) {
		this.block = block;
	}

}
