package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetEngineType extends Command{


    public SetEngineType(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().getEngine().setType(content);
    }
}
