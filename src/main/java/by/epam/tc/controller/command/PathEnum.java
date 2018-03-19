package by.epam.tc.controller.command;

public enum PathEnum {

    ERROR("/WEB-INF/jsp/error.jsp"),
    HOME("/WEB-INF/jsp/home.jsp"),
    MAIN("/WEB-INF/jsp/main.jsp");

    private String path;

    PathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
