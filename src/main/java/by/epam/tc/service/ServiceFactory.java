package by.epam.tc.service;

import by.epam.tc.service.impl.ParserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final ParserService parserService = new ParserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public ParserService getParserService() {
        return parserService;
    }
}
