package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetOrigin extends Command{

    private Plane plane;

    public SetOrigin(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setOrigin(content);
    }
}
