package ua.kiev.prog.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.JsonUsers;
import ua.kiev.prog.model.User;
import ua.kiev.prog.model.UserStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 14.12.2016.
 */
public class UsersList {
    private static final UsersList usrList = new UsersList();
    private final List<User> list;
    private final Gson gson;

    public static UsersList getInstance() {
        return usrList;
    }

    private UsersList() {
        list = new ArrayList<>();
        list.add(new User("Dima","123", UserStatus.OFFLINE));
        list.add(new User("Admin","qwezxc", UserStatus.OFFLINE));
        list.add(new User("test","sdf", UserStatus.OFFLINE));
        gson = new GsonBuilder().create();
    }

    public synchronized void addUser(User user){
        list.add(user);
    }

    public synchronized  void delUser(User user){
        list.remove(user);
    }

    public List<User> getList() {
        return list;
    }

    //public boolean isLogin

    public synchronized String toJSON() {
        return gson.toJson(new JsonUsers(list));
    }
}
