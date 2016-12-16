package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 14.12.2016.
 */
public class UsersList {
    private static final UsersList usrList = new UsersList();
    private final List<User> list;

    public static UsersList getInstance() {
        return usrList;
    }

    private UsersList() {
        list = new ArrayList<>();
        list.add(new User("Dima","123"));
        list.add(new User("Admin","qwezxc"));
        list.add(new User("test","sdf"));
    }

    public void addUser(User user){
        list.add(user);
    }

    public void delUser(User user){
        list.remove(user);
    }

    public List<User> getList() {
        return list;
    }

    //public boolean isLogin

}
