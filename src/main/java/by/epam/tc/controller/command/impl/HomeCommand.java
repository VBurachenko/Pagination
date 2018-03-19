package by.epam.tc.controller.command.impl;

import by.epam.tc.controller.command.Command;
import by.epam.tc.controller.command.PathEnum;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        return PathEnum.HOME.getPath();
    }
}
