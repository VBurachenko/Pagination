package by.epam.tc.dao.parser.dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.epam.tc.dao.parser.AbstractItemBuilder;
import by.epam.tc.entity.Engine;
import by.epam.tc.entity.Parameters;
import by.epam.tc.entity.Plane;

public class ItemsDOMBuilder extends AbstractItemBuilder {
	
	private DocumentBuilder docBuilder;

	public ItemsDOMBuilder() throws ParserConfigurationException {
		items = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		docBuilder = factory.newDocumentBuilder();
	}
	
	@Override
	public void buildListOfItems(InputStream stream) throws SAXException, IOException {
		Document document = docBuilder.parse(new InputSource(stream));
		Element root = document.getDocumentElement();
		NodeList planesList = root.getElementsByTagName("plane");
		for (int i = 0; i < planesList.getLength(); i++) {
			Element planeElement = (Element) planesList.item(i);
			Plane plane = buildItem(planeElement);
			items.add(plane);
		}
	}
	
	private Plane buildItem(Element planeElement) {
		Plane plane = new Plane();
		
		plane.setId(planeElement.getAttribute("id"));
		plane.setManufacturer(getElementTextContext(planeElement, "manufacturer"));
		plane.setModel(getElementTextContext(planeElement, "model"));
		plane.setOrigin(getElementTextContext(planeElement, "origin"));
		plane.setType(getElementTextContext(planeElement, "type"));
		
		int crew = Integer.parseInt(getElementTextContext(planeElement, "crew"));
		plane.setCrew(crew);
		
		int passCapacity = Integer.parseInt(getElementTextContext(planeElement, "passenger_capacity"));
		plane.setPassengerCapacity(passCapacity);
		
		int cargoCapacity = Integer.parseInt(getElementTextContext(planeElement, "cargo_capacity"));
		plane.setCargoCapacity(cargoCapacity);
		
		int price = Integer.parseInt(getElementTextContext(planeElement, "price"));
		plane.setPrice(price);
		
		Element engineElement = (Element) planeElement.getElementsByTagName("engines").item(0);
		Engine engine = plane.getEngine();
		
		int amount = Integer.parseInt(engineElement.getAttribute("amount"));
		engine.setAmount(amount);
		
		engine.setModel(getElementTextContext(engineElement, "eng_model"));
		engine.setType(getElementTextContext(engineElement, "eng_type"));
		
		Element paramsElement = (Element) planeElement.getElementsByTagName("parameters").item(0);
		Parameters parameters = plane.getParameters();
		
		parameters.setColor(paramsElement.getAttribute("color"));
		boolean radar = Boolean.valueOf(paramsElement.getAttribute("radar"));
		parameters.setRadar(radar);
		
		int height = Integer.parseInt(getElementTextContext(paramsElement, "height"));
		parameters.setHeight(height);
		
		int length = Integer.parseInt(getElementTextContext(paramsElement, "length"));
		parameters.setLength(length);
		
		int wingspan = Integer.parseInt(getElementTextContext(paramsElement, "wingspan"));
		parameters.setWingspan(wingspan);
		
		int grossWeight = Integer.parseInt(getElementTextContext(paramsElement, "gross_weight"));
		parameters.setGrossWeight(grossWeight);
		
		return plane;
	}
	
	private String getElementTextContext(Element element, String elementName) {
		NodeList nodeList = element.getElementsByTagName(elementName);
		Node node = nodeList.item(0);
		return node.getTextContent();
	}

	public List<Plane> getItems() {
		return items;
	}
	
	
	

}
