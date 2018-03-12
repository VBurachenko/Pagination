package by.epam.tc.dao.parser.sax;

import by.epam.tc.entity.Plane;

public abstract class Command {

    protected Plane plane;

    public Command(Plane plane) {
        this.plane = plane;
    }

    public abstract void execute(String content);

    public Plane getPlane() {
        return plane;
    }
}
