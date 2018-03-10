package by.epam.tc.dao.parser.sax.impl;

import by.epam.tc.dao.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.dao.util.Util.parseToInt;

public class SetCrew implements Command {

    private Plane plane;

    public SetCrew(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void execute(String content) {
        plane.setCrew(parseToInt(content));
    }
}
