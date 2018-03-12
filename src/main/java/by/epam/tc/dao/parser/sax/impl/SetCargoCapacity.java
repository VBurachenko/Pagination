package by.epam.tc.dao.parser.sax.impl;

import by.epam.tc.dao.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.dao.util.Util.parseToInt;

public class SetCargoCapacity extends Command {

    public SetCargoCapacity(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setCargoCapacity(parseToInt(content));
    }
}
