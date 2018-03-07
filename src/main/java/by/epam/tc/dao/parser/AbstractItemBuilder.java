package by.epam.tc.dao.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import by.epam.tc.entity.Plane;

public abstract class AbstractItemBuilder {
	
	protected List<Plane> items;
	
	public AbstractItemBuilder() {
		items = new ArrayList<Plane>();
	}

	public List<Plane> getItems() {
		return items;
	}
	
	public abstract void buildListOfItems(InputStream stream) throws IOException, SAXException, XMLStreamException;
	
}
