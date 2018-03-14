package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.parser.util.Util.parseToInt;

public class SetGrossWeight extends Command{

    public SetGrossWeight(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().getParameters().setGrossWeight(parseToInt(content));
    }
}
