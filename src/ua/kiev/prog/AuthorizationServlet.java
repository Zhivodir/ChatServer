package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 14.12.2016.
 */
public class AuthorizationServlet extends HttpServlet {
    private UsersList usrList = UsersList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean flag = false;
        for(User user : usrList.getList()){
            if((user.getName().equals(login))&&(user.getPswd().equals(password))){
                flag = true;
                break;
            }
        }
        if(flag){resp.setStatus(200);}
        else{resp.sendError(401);}
    }
}
