package by.epam.tc.dao.impl;

import by.epam.tc.dao.ParserDAO;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.parser.AbstractItemBuilder;
import by.epam.tc.dao.parser.ItemBuilderFactory;
import by.epam.tc.entity.Plane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;


public class ParserDAOImpl implements ParserDAO {

    private static final String XML_PATH = "planes.xml";

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Plane> getItemsList(String parserType) throws DAOException {
        List<Plane> planes;
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(XML_PATH)) {

            ItemBuilderFactory factory = new ItemBuilderFactory();
            AbstractItemBuilder builder = factory.createItemBuilder(parserType);
            builder.buildListOfItems(stream);
            planes = builder.getItems();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException(e.getMessage(), e.getCause());

        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException(e.getMessage(), e.getCause());

        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException(e.getMessage(), e.getCause());

        } catch (XMLStreamException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException(e.getMessage(), e.getCause());
        }
        return planes;
    }
}