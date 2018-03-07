package by.epam.tc.service;

import by.epam.tc.service.impl.ParserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ParserService parserService = new ParserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ParserService getParserService() {
        return parserService;
    }
}
