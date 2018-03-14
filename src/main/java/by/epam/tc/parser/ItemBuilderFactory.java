package by.epam.tc.parser;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.epam.tc.parser.dom.ItemDOMBuilder;
import by.epam.tc.parser.sax.ItemSAXBuilder;
import by.epam.tc.parser.stax.ItemStAXBuilder;

public class ItemBuilderFactory {
	
	private enum ParserType {
		SAX, DOM, STAX
	}
	
	public AbstractItemBuilder createItemBuilder(String parserType) throws SAXException, ParserConfigurationException {
		ParserType type = ParserType.valueOf(parserType.toUpperCase());
		switch (type) {
		
		case SAX:
			return new ItemSAXBuilder();
			
		case DOM:
			return new ItemDOMBuilder();
			
		case STAX:
			return new ItemStAXBuilder();
			
			default:
				throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}

}
