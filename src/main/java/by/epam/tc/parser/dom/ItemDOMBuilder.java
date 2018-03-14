package by.epam.tc.parser.dom;

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

import by.epam.tc.parser.AbstractItemBuilder;
import by.epam.tc.entity.Engine;
import by.epam.tc.entity.Parameters;
import by.epam.tc.entity.Plane;

import static by.epam.tc.parser.Constant.*;
import static by.epam.tc.parser.util.Util.parseToBoolean;
import static by.epam.tc.parser.util.Util.parseToInt;

public class ItemDOMBuilder extends AbstractItemBuilder {
	
	private DocumentBuilder docBuilder;

	public ItemDOMBuilder() throws ParserConfigurationException {
		items = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		docBuilder = factory.newDocumentBuilder();
	}
	
	@Override
	public void buildListOfItems(InputStream stream) throws SAXException, IOException {
		Document document = docBuilder.parse(new InputSource(stream));
		Element root = document.getDocumentElement();
		NodeList planesList = root.getElementsByTagName(PLANE);
		for (int i = 0; i < planesList.getLength(); i++) {
			Element planeElement = (Element) planesList.item(i);
			Plane plane = buildItem(planeElement);
			items.add(plane);
		}
	}
	
	private Plane buildItem(Element planeElement) {
		Plane plane = new Plane();
		
		plane.setId(planeElement.getAttribute(ID));
		plane.setManufacturer(getElementTextContext(planeElement, MANUFACTURER));
		plane.setModel(getElementTextContext(planeElement, MODEL));
		plane.setOrigin(getElementTextContext(planeElement, ORIGIN));
		plane.setType(getElementTextContext(planeElement, TYPE));
		
		int crew = parseToInt(getElementTextContext(planeElement, CREW));
		plane.setCrew(crew);
		
		int passCapacity = parseToInt(getElementTextContext(planeElement, PASS_CAPACITY));
		plane.setPassengerCapacity(passCapacity);
		
		int cargoCapacity = parseToInt(getElementTextContext(planeElement, CARGO_CAPACITY));
		plane.setCargoCapacity(cargoCapacity);
		
		int price = parseToInt(getElementTextContext(planeElement, PRICE));
		plane.setPrice(price);
		
		Element engineElement = (Element) planeElement.getElementsByTagName(ENGINES).item(0);
		Engine engine = plane.getEngine();
		
		int amount = parseToInt(engineElement.getAttribute(AMOUNT));
		engine.setAmount(amount);
		
		engine.setModel(getElementTextContext(engineElement, ENG_MODEL));
		engine.setType(getElementTextContext(engineElement, ENG_TYPE));
		
		Element paramsElement = (Element) planeElement.getElementsByTagName(PARAMS).item(0);
		Parameters parameters = plane.getParameters();
		
		parameters.setColor(paramsElement.getAttribute(COLOR));

		boolean radar = parseToBoolean(paramsElement.getAttribute(RADAR));
		parameters.setRadar(radar);
		
		int height = parseToInt(getElementTextContext(paramsElement, HEIGHT));
		parameters.setHeight(height);
		
		int length = parseToInt(getElementTextContext(paramsElement, LENGTH));
		parameters.setLength(length);
		
		int wingspan = parseToInt(getElementTextContext(paramsElement, WINGSPAN));
		parameters.setWingspan(wingspan);
		
		int grossWeight = parseToInt(getElementTextContext(paramsElement, GROSS_WEIGHT));
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
