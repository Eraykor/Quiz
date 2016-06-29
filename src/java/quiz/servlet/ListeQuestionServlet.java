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
@WebServlet(name = "ListeQuestionServlet", urlPatterns = {"/liste_question"})
public class ListeQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        QuestionService questionService = new QuestionService();
        
        long quuizId = (long) req.getSession().getAttribute("quizId");
        
        List<Question> questions = questionService.rechercheQuestion(quuizId);
        
        req.setAttribute("questions", questions);
        
        req.getRequestDispatcher("liste_question.jsp").forward(req, resp);
    }
}
