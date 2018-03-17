package by.epam.tc.entity;

import java.util.Objects;

public class Parameters {
	
	private String color;
	
	private boolean radar;
	
	private int height;
	
	private int length;
	
	private int wingspan;
	
	private int grossWeight;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isRadar() {
		return radar;
	}

	public void setRadar(boolean radar) {
		this.radar = radar;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int hight) {
		this.height = hight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}

	public int getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(int grossWeight) {
		this.grossWeight = grossWeight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Parameters that = (Parameters) o;
		return isRadar() == that.isRadar() &&
				getHeight() == that.getHeight() &&
				getLength() == that.getLength() &&
				getWingspan() == that.getWingspan() &&
				getGrossWeight() == that.getGrossWeight() &&
				Objects.equals(getColor(), that.getColor());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getColor(), isRadar(), getHeight(), getLength(), getWingspan(), getGrossWeight());
	}

	@Override
	public String toString() {
		return "Parameters [color=" + color + ", radar=" + radar + ", hight=" + height + ", length=" + length
				+ ", wingspan=" + wingspan + ", grossWeight=" + grossWeight + "]";
	}
	
	

}
