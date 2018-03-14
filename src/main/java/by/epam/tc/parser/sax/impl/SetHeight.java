package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.parser.util.Util.parseToInt;

public class SetHeight extends Command{

    public SetHeight(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().getParameters().setHeight(parseToInt(content));
    }
}
