package by.epam.tc.controller.command;

import by.epam.tc.controller.command.impl.HomeCommand;
import by.epam.tc.controller.command.impl.ParseCommand;

import java.util.HashMap;
import java.util.Map;

import static by.epam.tc.controller.command.mapping.UrlPattern.HOME;
import static by.epam.tc.controller.command.mapping.UrlPattern.MAIN;

public final class CommandFactory {

    private static final CommandFactory INSTANCE = new CommandFactory();

    private CommandFactory(){
    }

    private static final Map<String, Command> ACTIONS = new HashMap<String, Command>(){
        {
            put(MAIN, new ParseCommand());
            put(HOME, new HomeCommand());
        }
    };

    public Command getAction(String actionName){
        return ACTIONS.get(actionName);
    }

    public static CommandFactory getInstance() {
        return INSTANCE;
    }
}