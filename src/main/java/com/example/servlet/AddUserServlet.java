package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.User;
import com.example.Warehouse;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String index = "jsp/add.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(index);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.addUser(user);

        req.setAttribute("userName", firstName);
        req.setAttribute("lastName", lastName);

        try{
            resp.sendRedirect("/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
