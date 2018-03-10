package by.epam.tc.dao.parser.sax;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tc.dao.parser.ItemEnum;
import by.epam.tc.entity.Plane;

import static by.epam.tc.dao.util.Util.parseToInt;

public class ItemHandler extends DefaultHandler {

	private List<Plane> itemsList;
	private Plane currentPlane;
	private ItemEnum currentItem;
	private EnumSet<ItemEnum> description;

	public ItemHandler() {
		itemsList = new ArrayList<>();
		description = EnumSet.range(ItemEnum.MANUFACTURER, ItemEnum.GROSS_WEIGHT);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName.equals(ItemEnum.PLANE.getValue())) {
			currentPlane = new Plane();
		} else {
			ItemEnum temp = ItemEnum.valueOf(localName.toUpperCase());
			if (description.contains(temp)) {
				currentItem = temp;
			}
		}
		if (attributes.getLength() != 0){
			setAttributes(attributes);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (currentPlane != null){
			CommandFactory factory = new CommandFactory(currentPlane);
			if (currentItem != null){
				Command command = factory.getAction(currentItem);
				command.execute(content);
			}
		}
		currentItem = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals(ItemEnum.PLANE.getValue())) {
			itemsList.add(currentPlane);
		}
	}

	private void setAttributes(Attributes attributes) {

		if (attributes.getLength() == 1) {
			String attrId = ItemEnum.ID.getValue();
			String attrAmount = ItemEnum.AMOUNT.getValue();

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

	public List<Plane> getItemsList() {
		return itemsList;
	}

}
