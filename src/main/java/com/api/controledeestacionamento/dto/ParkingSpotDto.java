package com.api.controledeestacionamento.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class ParkingSpotDto.
 */
public class ParkingSpotDto {

	/** The parcking spot number. */
	@NotBlank
	private String parckingSpotNumber;
	
	/** The license plate car. */
	@NotBlank
	@Size(max = 7)
	private String licensePlateCar;
	
	/** The brand car. */
	@NotBlank
	private String brandCar;
	
	/** The model car. */
	@NotBlank
	private String modelCar;
	
	/** The color car. */
	@NotBlank
	private String colorCar;
	
	/** The responsible name. */
	@NotBlank
	private String responsibleName;
	
	/** The apartment. */
	@NotBlank
	private String apartment;
	
	/** The block. */
	@NotBlank
	private String block;

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
