package ba.smoki.sport.db;

public enum ConnectionParam {
    URL("jdbc:mysql://localhost:3306/players"),
    USER("root"),
    PASSWORD("root");

    private String value;

    ConnectionParam(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
