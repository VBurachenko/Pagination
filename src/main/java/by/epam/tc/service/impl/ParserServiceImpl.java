package by.epam.tc.service.impl;

import by.epam.tc.dao.DAOFactory;
import by.epam.tc.dao.ParserDAO;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.entity.Plane;
import by.epam.tc.service.ParserService;
import by.epam.tc.service.exception.ServiceException;

import java.util.List;

public class ParserServiceImpl implements ParserService{

    @Override
    public List<Plane> getItems(String parserTypeName, int offset, int start) throws ServiceException{

        DAOFactory factory = DAOFactory.getInstance();
        ParserDAO parserDAO = factory.getParserDAO();

        int end = start + offset;

        try {
            List<Plane> itemsList = parserDAO.getItemsList(parserTypeName);

            if (end > itemsList.size()){
                return itemsList.subList(start, itemsList.size());
            }
            return itemsList.subList(start, end);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public int generateCountOfPages(String parserTypeName, int itemsPerPage) throws ServiceException{

        int totalCountOfItems = getTotalCountOfItems(parserTypeName);

        return (int) Math.ceil(totalCountOfItems * 1.0/ itemsPerPage);
    }


    private int getTotalCountOfItems(String parserTypeName) throws ServiceException {

        DAOFactory factory = DAOFactory.getInstance();
        ParserDAO parserDAO = factory.getParserDAO();

        try {

            return parserDAO.getItemsList(parserTypeName).size();

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
}
