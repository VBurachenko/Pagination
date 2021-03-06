package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetModel extends Command{

    private Plane plane;

    public SetModel(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setModel(content);
    }
}
