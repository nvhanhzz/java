package controller;

import dao.CustomerDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Customer;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        // Regex để kiểm tra độ phức tạp của mật khẩu mới
        String passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}$";

        // Kiểm tra xem mật khẩu mới có hợp lệ không
        if (!newPassword.matches(passwordPattern)) {
            response.sendRedirect("changePassword.jsp?error=Password must be at least 8 characters long, include at least one digit, one uppercase letter, and one special character.");
            return;
        }

        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.findByUsername(username);

        // Kiểm tra mật khẩu cũ
        if (customer != null && customer.getPassword().equals(oldPassword)) {
            dao.updatePassword(username, newPassword);
            response.sendRedirect("login.jsp?message=Password changed successfully");
        } else {
            response.sendRedirect("changePassword.jsp?error=Invalid current password");
        }
    }
}
