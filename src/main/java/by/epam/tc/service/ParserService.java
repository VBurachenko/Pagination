package by.epam.tc.service;

import by.epam.tc.entity.Plane;
import by.epam.tc.service.exception.ServiceException;

import java.util.List;

public interface ParserService {

    List<Plane> getItems(String parserTypeName, int offset, int start)
            throws ServiceException;

    int generateCountOfPages(String parsetTypeName, int itemsPerPage) throws ServiceException;
}
