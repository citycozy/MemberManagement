package db;

public enum DBInfo {
    CLASSNAME("org.mariadb.jdbc.Driver"),
    URL("jdbc:mariadb://localhost:3306/"),
    USER(""),
    PASSWORD("");
    // USER, PASSWORD 기입, URL 에 DB명 기입 후 사용

    private final String value;

    DBInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}