package by.epam.tc.entity;

import java.util.Objects;

public class Plane {

	private String id;

	private String manufacturer;

	private String model;

	private String origin;

	private String type;

	private int crew;

	private int passengerCapacity;

	private int cargoCapacity;

	private int price;

	private Engine engine;

	private Parameters parameters;

	public Plane() {
		engine = new Engine();
		parameters = new Parameters();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Plane plane = (Plane) o;
		return getCrew() == plane.getCrew() &&
				getPassengerCapacity() == plane.getPassengerCapacity() &&
				getCargoCapacity() == plane.getCargoCapacity() &&
				getPrice() == plane.getPrice() &&
				Objects.equals(getId(), plane.getId()) &&
				Objects.equals(getManufacturer(), plane.getManufacturer()) &&
				Objects.equals(getModel(), plane.getModel()) &&
				Objects.equals(getOrigin(), plane.getOrigin()) &&
				Objects.equals(getType(), plane.getType()) &&
				Objects.equals(getEngine(), plane.getEngine()) &&
				Objects.equals(getParameters(), plane.getParameters());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getManufacturer(), getModel(), getOrigin(), getType(), getCrew(), getPassengerCapacity(), getCargoCapacity(), getPrice(), getEngine(), getParameters());
	}

	@Override
	public String toString() {
		return "Plane [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", origin=" + origin
				+ ", type=" + type + ", crew=" + crew + ", passengerCapacity=" + passengerCapacity + ", cargoCapacity="
				+ cargoCapacity + ", price=" + price + ", engines=" + engine + ", parameters=" + parameters + "]";
	}

}