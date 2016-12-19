package ua.kiev.prog.servlets;

import ua.kiev.prog.model.User;
import ua.kiev.prog.repository.UsersList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by User on 19.12.2016.
 */
public class GetUserStatus extends HttpServlet {
    private UsersList usrList = UsersList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String json = "";
        for(User user : usrList.getList()){
            if(user.getName().equals(login)){
                json = user.toJSON();
                break;
            }
        }if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }
}
