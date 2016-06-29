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
import quiz.entity.Question;
import quiz.entity.Quiz;
import quiz.service.QuestionService;
import quiz.service.QuizService;

/**
 *
 * @author admin
 */
@WebServlet(name = "RouteJouerQuizServlet", urlPatterns = {"/jouer_quiz"})
public class RouteJouerQuizServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        byte ordre = 0;
        int score = 0;
        
        QuizService service = new QuizService();
        QuestionService questionService = new QuestionService();
        
        long quuizId = Long.parseLong(req.getParameter("quizId"));
        
        Quiz q = service.rechercheQuizz(quuizId);
        
        // Place quizId et quizNom en session
        req.getSession().setAttribute("quizId", q.getId());
        req.getSession().setAttribute("quizNom", q.getNom());
        
        List<Question> question = questionService.rechercheQuestionOrdre(quuizId, ordre);
        
        req.setAttribute("quizQuestion", question.get(0));
        
        byte order = question.get(0).getOrdre();
        
        req.getSession().setAttribute("score", score);
        req.getSession().setAttribute("ordre", order);
        req.getSession().setAttribute("bonneRep", question.get(0).getNumRepCorrect());
        
        System.out.println(order);
        
        req.getRequestDispatcher("jouer_quiz.jsp").forward(req, resp);
    }
}
