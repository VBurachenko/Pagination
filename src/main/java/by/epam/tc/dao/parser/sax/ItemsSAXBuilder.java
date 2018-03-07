package by.epam.tc.dao.parser.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.tc.dao.parser.AbstractItemBuilder;
import by.epam.tc.entity.Plane;

public class ItemsSAXBuilder extends AbstractItemBuilder {
	
	private ItemHandler itemHandler;
	
	private XMLReader reader;

	public ItemsSAXBuilder() throws SAXException {
		itemHandler = new ItemHandler();
		reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(itemHandler);
	}
	
	public void buildListOfItems(InputStream inputStream) throws IOException, SAXException {
		reader.parse(new InputSource(inputStream));
		items = itemHandler.getPlanes();
	}
	
	public List<Plane> getItems(){
		return items;
	}

}
