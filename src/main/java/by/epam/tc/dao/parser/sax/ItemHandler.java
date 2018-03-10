package by.epam.tc.dao.parser.sax;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tc.dao.parser.ItemField;
import by.epam.tc.entity.Plane;

public class ItemHandler extends DefaultHandler {

	private List<Plane> itemsList;
	private Plane currentItem;
	private ItemField field;
	private EnumSet<ItemField> fieldsSet;

	public ItemHandler() {
		itemsList = new ArrayList<>();
		fieldsSet = EnumSet.range(ItemField.MANUFACTURER, ItemField.GROSS_WEIGHT);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName.equals(ItemField.PLANE.getValue())) {
			currentItem = new Plane();
		} else {
			ItemField temp = ItemField.valueOf(localName.toUpperCase());
			if (fieldsSet.contains(temp)) {
				field = temp;
			}
		}
		if (attributes.getLength() != 0){
			setAttributes(attributes);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (currentItem != null && field != null){
			CommandFactory factory = new CommandFactory(currentItem);
			Command command = factory.getAction(field);
			command.execute(content);
		}
		field = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals(ItemField.PLANE.getValue())) {
			itemsList.add(currentItem);
		}
	}

	private void setAttributes(Attributes attributes) {

		if (attributes.getLength() == 1) {
			String attrId = ItemField.ID.getValue();
			String attrAmount = ItemField.AMOUNT.getValue();

			if (attributes.getLocalName(0).equals(attrId)) {
				currentItem.setId(attributes.getValue(0));
			} else if(attributes.getLocalName(0).equals(attrAmount)){
				int amount = Integer.valueOf(attributes.getValue(0));
				currentItem.getEngine().setAmount(amount);
			}

		} else {

			String color = attributes.getValue(0);
			boolean radar = Boolean.valueOf(attributes.getValue(1));

			currentItem.getParameters().setColor(color);
			currentItem.getParameters().setRadar(radar);

		}
	}

	public List<Plane> getItemsList() {
		return itemsList;
	}

}
