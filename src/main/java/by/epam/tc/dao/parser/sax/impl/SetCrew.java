package by.epam.tc.dao.parser.sax.impl;

import by.epam.tc.dao.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.dao.util.Util.parseToInt;

public class SetCrew extends Command {

    public SetCrew(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setCrew(parseToInt(content));
    }
}
