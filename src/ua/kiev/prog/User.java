package ua.kiev.prog;

/**
 * Created by User on 14.12.2016.
 */
public class User {
    private String name;
    private String pswd;

    public User(String name, String pswd) {
        this.name = name;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public String getPswd() {
        return pswd;
    }
}
