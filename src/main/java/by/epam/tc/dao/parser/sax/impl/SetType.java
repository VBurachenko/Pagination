package by.epam.tc.dao.parser.sax.impl;

import by.epam.tc.dao.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetType implements Command{

    private Plane plane;

    public SetType(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void execute(String content) {
        plane.setType(content);
    }
}
