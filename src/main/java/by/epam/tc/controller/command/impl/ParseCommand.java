package by.epam.tc.controller.command.impl;

import by.epam.tc.controller.command.Command;
import by.epam.tc.controller.command.PathEnum;
import by.epam.tc.entity.Plane;
import by.epam.tc.service.ParserService;
import by.epam.tc.service.ServiceFactory;
import by.epam.tc.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParseCommand implements Command {

    private static final int ITEMS_PER_PAGE = 1;

    private static final int FIRST = 1;

    private static final String COMMAND = "command";

    private static final String PAGE = "page";

    private static final String COUNT_OF_PAGES = "countOfPages";

    private static final String ITEMS = "items";

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {

        final ServiceFactory factory = ServiceFactory.getInstance();
        ParserService parserService = factory.getParserService();

        String parserTypeName = request.getParameter(COMMAND);

        List<Plane> items;
        int countOfPages;
        int page = setPage(request);

        try {

            items = parserService.getItems(parserTypeName, ITEMS_PER_PAGE,
                    (page - 1) * ITEMS_PER_PAGE);

            countOfPages = parserService.generateCountOfPages(parserTypeName, ITEMS_PER_PAGE);

        } catch (ServiceException e) {
            LOGGER.error(e.getMessage());
            return PathEnum.ERROR.getPath();
        }

        request.setAttribute(ITEMS, items);
        request.setAttribute(COUNT_OF_PAGES, countOfPages);
        request.setAttribute(PAGE, page);
        request.setAttribute(COMMAND, parserTypeName);

        return PathEnum.MAIN.getPath();
    }

    private int setPage(HttpServletRequest request){
        if (request.getParameter(PAGE) != null) {
            return Integer.parseInt(request.getParameter(PAGE));
        } else {
            return FIRST;
        }
    }


}