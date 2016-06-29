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
import quiz.service.QuizService;

/**
 *
 * @author admin
 */
@WebServlet(name = "SupprimerQuizActuelServlet", urlPatterns = {"/supprimer_quiz_actuel"})
public class SupprimerQuizActuelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("quiz_home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long idQuiz = Long.parseLong(req.getParameter("quizId"));
        
        new QuizService().supprimerQuiz(idQuiz);
        
        resp.sendRedirect("quiz_home");
    }
}
