package by.epam.tc.dao.parser.stax;

import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.tc.dao.parser.AbstractItemBuilder;
import by.epam.tc.dao.parser.ItemField;
import by.epam.tc.entity.Engine;
import by.epam.tc.entity.Parameters;
import by.epam.tc.entity.Plane;

import static by.epam.tc.dao.util.Util.parseToBoolean;
import static by.epam.tc.dao.util.Util.parseToInt;

public class ItemsStAXBuilder extends AbstractItemBuilder {
		
	private XMLInputFactory inputFactory;

	public ItemsStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
	@Override
	public void buildListOfItems(InputStream stream) throws XMLStreamException {
		XMLStreamReader reader = inputFactory.createXMLStreamReader(stream);
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				name = reader.getLocalName();
				if (ItemField.valueOf(name.toUpperCase()) == ItemField.PLANE) {
					Plane plane = buildPlane(reader);
					items.add(plane);
				}
			}
		}
	}
	
	private Plane buildPlane(XMLStreamReader reader) throws XMLStreamException {
		Plane plane = new Plane();
		plane.setId(reader.getAttributeValue(null, ItemField.ID.getValue()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (ItemField.valueOf(name.toUpperCase())) {
				case MANUFACTURER:
					plane.setManufacturer(getXMLText(reader));
					break;
				case MODEL:
					plane.setModel(getXMLText(reader));
					break;
				case ORIGIN:
					plane.setOrigin(getXMLText(reader));
					break;
				case TYPE:
					plane.setType(getXMLText(reader));
					break;
				case CREW:
					int crew = parseToInt(getXMLText(reader));
					plane.setCrew(crew);
					break;
				case PASSENGER_CAPACITY:
					int passCapacity = parseToInt(getXMLText(reader));
					plane.setPassengerCapacity(passCapacity);
					break;
				case CARGO_CAPACITY:
					int cargCapacity = parseToInt(getXMLText(reader));
					plane.setCargoCapacity(cargCapacity);
					break;
				case PRICE:
					int price = parseToInt(getXMLText(reader));
					plane.setPrice(price);
					break;
				case ENGINES:
					plane.setEngine(getXMLEngines(reader));
					break;
				case PARAMETERS:
					plane.setParameters(getXMLParameters(reader));
					break;
					default:
						break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (ItemField.valueOf(name.toUpperCase()) == ItemField.PLANE) {
					return plane;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Plane");
	}
	
	private Engine getXMLEngines(XMLStreamReader reader) throws XMLStreamException {
		Engine engine = new Engine();
		int amount = parseToInt(reader.getAttributeValue(null, ItemField.AMOUNT.getValue()));
		engine.setAmount(amount);
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (ItemField.valueOf(name.toUpperCase())) {
				case ENG_TYPE:
					engine.setType(getXMLText(reader));
					break;
				case ENG_MODEL:
					engine.setModel(getXMLText(reader));
					break;
					default:
						break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (ItemField.valueOf(name.toUpperCase()) == ItemField.ENGINES) {
					return engine;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Engine");
	}
	
	private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
		Parameters params = new Parameters();
		
		params.setColor(reader.getAttributeValue(null, ItemField.COLOR.getValue()));

		boolean radar = parseToBoolean(reader.getAttributeValue(null, ItemField.RADAR.getValue()));
		params.setRadar(radar);
		
		int type;
		String name;
		
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch(ItemField.valueOf(name.toUpperCase())) {
				case HEIGHT:
					int height = parseToInt(getXMLText(reader));
					params.setHeight(height);
					break;
				case LENGTH:
					int length = parseToInt(getXMLText(reader));
					params.setLength(length);
					break;
				case WINGSPAN:
					int wingspan = parseToInt(getXMLText(reader));
					params.setWingspan(wingspan);
					break;
				case GROSS_WEIGHT:
					int grossWeight = parseToInt(getXMLText(reader));
					params.setGrossWeight(grossWeight);
					break;
					default:break;
				}
				break;
			
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (ItemField.valueOf(name.toUpperCase()) == ItemField.PARAMETERS) {
					return params;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Engine");
	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

	public List<Plane> getItems() {
		return items;
	}
	
}