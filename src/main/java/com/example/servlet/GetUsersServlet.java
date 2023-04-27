package com.example.servlet;

import com.example.User;
import com.example.Warehouse;
import java.io.IOException;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final static String index = "jsp/users.jsp";

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<User> users = Warehouse.getInstance().getUsers();
        req.setAttribute("users",users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(index);
       try {
           requestDispatcher.forward(req, resp);
       }catch (ServletException | IOException e){
           e.printStackTrace();
       }
    }

}
