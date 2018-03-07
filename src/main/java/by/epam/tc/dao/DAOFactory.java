package by.epam.tc.dao;

import by.epam.tc.dao.impl.ParserDAOImpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final ParserDAO parserDAO = new ParserDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ParserDAO getParserDAO() {
        return parserDAO;
    }
}
