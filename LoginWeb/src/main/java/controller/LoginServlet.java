package controller;

import dao.CustomerDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Customer;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.findByUsername(username);

        if (customer != null && customer.getPassword().equals(password)) {
            request.getSession().setAttribute("customer", customer);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }
}
