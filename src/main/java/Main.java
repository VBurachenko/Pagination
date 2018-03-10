import by.epam.tc.dao.parser.AbstractItemBuilder;
import by.epam.tc.dao.parser.sax.ItemsSAXBuilder;
import by.epam.tc.dao.parser.stax.ItemsStAXBuilder;
import by.epam.tc.service.ParserService;
import by.epam.tc.service.ServiceFactory;
import by.epam.tc.service.exception.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private final static String PATH = "src/main/resources/planes.xml";

    public static void main(String[] args) {

        try (InputStream stream = new FileInputStream(PATH)){
            AbstractItemBuilder ab = new ItemsStAXBuilder();
            ab.buildListOfItems(stream);
            System.out.println(ab.getItems());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
