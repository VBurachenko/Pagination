package by.epam.tc.parser.sax.impl;

import by.epam.tc.parser.sax.Command;
import by.epam.tc.entity.Plane;

import static by.epam.tc.parser.util.Util.parseToInt;

public class SetPassengerCapacity extends Command {


    public SetPassengerCapacity(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().setPassengerCapacity(parseToInt(content));
    }
}
