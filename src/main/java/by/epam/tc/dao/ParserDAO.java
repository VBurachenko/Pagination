package by.epam.tc.dao;

import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.entity.Plane;

import java.util.List;

public interface ParserDAO {

    List<Plane> getItemsList(String parserType) throws DAOException;
}
