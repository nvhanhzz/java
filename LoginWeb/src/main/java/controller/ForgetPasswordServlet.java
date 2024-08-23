package controller;

import dao.CustomerDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Customer;

public class ForgetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identifier = request.getParameter("identifier");

        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.findByEmailOrPhone(identifier);

        if (customer != null) {
            // Logic to send reset password link or OTP (e.g., via email or SMS)
            response.sendRedirect("login.jsp?message=Password reset link sent");
        } else {
            response.sendRedirect("forgetPassword.jsp?error=Email or phone not found");
        }
    }
}
