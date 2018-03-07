package by.epam.tc.dao.parser.sax;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tc.dao.parser.PlaneEnum;
import by.epam.tc.entity.Plane;

public class ItemHandler extends DefaultHandler {

	private List<Plane> planes;
	private Plane currentPlane;
	private PlaneEnum currentDescription;
	private EnumSet<PlaneEnum> description;

	public ItemHandler() {
		planes = new ArrayList<>();
		description = EnumSet.range(PlaneEnum.MANUFACTURER, PlaneEnum.GROSS_WEIGHT);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName.equals(PlaneEnum.PLANE.getValue())) {
			currentPlane = new Plane();
		} else {
			PlaneEnum temp = PlaneEnum.valueOf(localName.toUpperCase());
			if (description.contains(temp)) {
				currentDescription = temp;
			}
		}
		if (attributes.getLength() != 0){
			setAttributes(attributes);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (currentDescription != null) {
			switch (currentDescription) {
			case MANUFACTURER:
				currentPlane.setManufacturer(content);
				break;
			case MODEL:
				currentPlane.setModel(content);
				break;
			case ORIGIN:
				currentPlane.setOrigin(content);
				break;
			case TYPE:
				currentPlane.setType(content);
				break;
			case CREW:
				currentPlane.setCrew(parseToInt(content));
				break;
			case PASSENGER_CAPACITY:
				currentPlane.setPassengerCapacity(parseToInt(content));
				break;
			case CARGO_CAPACITY:
				currentPlane.setCargoCapacity(parseToInt(content));
				break;
			case PRICE:
				currentPlane.setPrice(parseToInt(content));
				break;
			case ENG_MODEL:
				currentPlane.getEngine().setModel(content);
				break;
			case ENG_TYPE:
				currentPlane.getEngine().setType(content);
				break;
			case HEIGHT:
				currentPlane.getParameters().setHeight(parseToInt(content));
				break;
			case LENGTH:
				currentPlane.getParameters().setLength(parseToInt(content));
				break;
			case WINGSPAN:
				currentPlane.getParameters().setWingspan(parseToInt(content));
				break;
			case GROSS_WEIGHT:
				currentPlane.getParameters().setGrossWeight(parseToInt(content));
				break;
			default:
				throw new EnumConstantNotPresentException(currentDescription.getDeclaringClass(),
						currentDescription.name());
			}
		}
		currentDescription = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals(PlaneEnum.PLANE.getValue())) {
			planes.add(currentPlane);
		}
	}

	private void setAttributes(Attributes attributes) {

		if (attributes.getLength() == 1) {
			String attrId = PlaneEnum.ID.getValue();
			String attrAmount = PlaneEnum.AMOUNT.getValue();

			if (attributes.getLocalName(0).equals(attrId)) {
				currentPlane.setId(attributes.getValue(0));
			} else if(attributes.getLocalName(0).equals(attrAmount)){
				int amount = Integer.valueOf(attributes.getValue(0));
				currentPlane.getEngine().setAmount(amount);
			}

		} else {

			String color = attributes.getValue(0);
			boolean radar = Boolean.valueOf(attributes.getValue(1));

			currentPlane.getParameters().setColor(color);
			currentPlane.getParameters().setRadar(radar);

		}
	}

	private int parseToInt(String s) {
		return Integer.parseInt(s);
	}

	public List<Plane> getPlanes() {
		return planes;
	}

}
