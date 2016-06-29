/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginControlServlet", urlPatterns = {"/connection"})
public class LoginControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String log = req.getParameter("login");
        String pass = req.getParameter("mdp");
        
        if (log.equals("admin") && pass.equals("admin")) {
            req.getSession().setAttribute("login", log);
            
            resp.sendRedirect("quiz_home");
        } else {
            resp.sendRedirect("login");
        }
    }
}
