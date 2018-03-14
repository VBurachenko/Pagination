package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.parser.util.Util.parseToInt;

public class SetPrice extends Command{

    public SetPrice(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setPrice(parseToInt(content));
    }
}
