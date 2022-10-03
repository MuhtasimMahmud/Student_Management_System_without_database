package users;

public class Faculty {

    private static String name = "310";
    private static String password = "310";

    public Faculty(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }
}
