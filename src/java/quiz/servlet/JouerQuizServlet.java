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
@WebServlet(name = "JouerQuizServlet", urlPatterns = {"/play"})
public class JouerQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int score = (int) req.getSession().getAttribute("score");
        
        QuestionService questionService = new QuestionService();
        byte ordre = (byte) req.getSession().getAttribute("ordre");
        long idQuiz = (long) req.getSession().getAttribute("quizId");
        String reponse = req.getParameter("rep");

        List<Question> question = questionService.rechercheQuestionOrdre(idQuiz, ordre);

        if (reponse.equals(req.getSession().getAttribute("bonneRep").toString())) {
            score = score +1;
            req.getSession().setAttribute("score", score);
        }
        
        if (question.isEmpty()) {

            resp.sendRedirect("score");
            
        } else {
            req.setAttribute("quizQuestion", question.get(0));
            
            byte order = question.get(0).getOrdre();

            req.getSession().setAttribute("ordre", order);

            req.getRequestDispatcher("jouer_quiz.jsp").forward(req, resp);
            
        }
    }
}
