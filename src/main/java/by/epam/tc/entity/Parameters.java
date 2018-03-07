package by.epam.tc.entity;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + grossWeight;
		result = prime * result + height;
		result = prime * result + length;
		result = prime * result + (radar ? 1231 : 1237);
		result = prime * result + wingspan;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameters other = (Parameters) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (grossWeight != other.grossWeight)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (radar != other.radar)
			return false;
		if (wingspan != other.wingspan)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parameters [color=" + color + ", radar=" + radar + ", hight=" + height + ", length=" + length
				+ ", wingspan=" + wingspan + ", grossWeight=" + grossWeight + "]";
	}
	
	

}
