package by.epam.tc.dao.parser;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.epam.tc.dao.parser.dom.ItemsDOMBuilder;
import by.epam.tc.dao.parser.sax.ItemsSAXBuilder;
import by.epam.tc.dao.parser.stax.ItemsStAXBuilder;

public class ItemBuilderFactory {
	
	private enum ParserType {
		SAX, DOM, STAX
	}
	
	public AbstractItemBuilder createItemBuilder(String parserType) throws SAXException, ParserConfigurationException {
		ParserType type = ParserType.valueOf(parserType.toUpperCase());
		switch (type) {
		
		case SAX:
			return new ItemsSAXBuilder();
			
		case DOM:
			return new ItemsDOMBuilder();
			
		case STAX:
			return new ItemsStAXBuilder();
			
			default:
				throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}

}
