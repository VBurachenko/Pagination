package by.epam.tc.dao.parser.sax.impl;

import by.epam.tc.dao.parser.sax.Command;
import by.epam.tc.entity.Plane;

public class SetEngineModel extends Command {

    public SetEngineModel(Plane plane) {
        super(plane);
    }

    @Override
    public void execute(String content) {
        getPlane().getEngine().setModel(content);
    }
}
