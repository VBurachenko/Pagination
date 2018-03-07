package by.epam.tc.controller.command;

public enum UrlEnum {

    ERROR("/WEB-INF/jsp/error.jsp"),
    HOME("/WEB-INF/jsp/home.jsp"),
    MAIN("/WEB-INF/jsp/main.jsp");

    private String path;

    UrlEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
