package by.epam.tc.controller.command;

import by.epam.tc.controller.command.impl.HomeCommand;
import by.epam.tc.controller.command.impl.ParseCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {

    private static final CommandFactory instance = new CommandFactory();

    private CommandFactory(){
    }

    private static final Map<String, Command> ACTIONS = new HashMap<String, Command>(){
        {
            put("/main.do", new ParseCommand());
            put("/home.do", new HomeCommand());
        }
    };

    public Command getAction(String actionName){
        return ACTIONS.get(actionName);
    }

    public static CommandFactory getInstance() {
        return instance;
    }
}