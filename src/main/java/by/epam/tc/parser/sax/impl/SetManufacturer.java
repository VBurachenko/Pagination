package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetManufacturer extends Command{

    public SetManufacturer(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setManufacturer(content);
    }
}
