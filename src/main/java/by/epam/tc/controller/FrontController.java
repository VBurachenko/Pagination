package by.epam.tc.controller;

import by.epam.tc.controller.command.Command;
import by.epam.tc.controller.command.CommandFactory;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prepareResponse(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        prepareResponse(request, response);
    }

    private void prepareResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getServletPath();

        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getAction(actionName);

        String url = command.execute(request);
        request.getRequestDispatcher(url).forward(request, response);

    }

}