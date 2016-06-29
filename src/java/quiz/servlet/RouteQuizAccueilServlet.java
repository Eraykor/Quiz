/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.entity.Quiz;
import quiz.service.QuizService;

/**
 *
 * @author admin
 */
@WebServlet(name = "RouteQuizAccueil", urlPatterns = {"/quiz_home"})
public class RouteQuizAccueilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        QuizService service = new QuizService();
        
        List<Quiz> quizFound = service.listerQuiz();
        
        req.setAttribute("quiz", quizFound);
        
        req.getRequestDispatcher("quiz_home.jsp").forward(req, resp);
    }
}
