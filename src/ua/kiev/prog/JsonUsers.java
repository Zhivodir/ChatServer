package ua.kiev.prog;

import ua.kiev.prog.model.User;

import java.util.List;

/**
 * Created by User on 18.12.2016.
 */
public class JsonUsers {
    private final List<User> usersList;

    public JsonUsers(List<User> usersList) {
        this.usersList = usersList;
    }
}
