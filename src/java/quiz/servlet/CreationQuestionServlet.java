/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
@WebServlet(name = "CreationQuestionServlet", urlPatterns = {"/create_question"})
public class CreationQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("create_question.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long id = (long) req.getSession().getAttribute("quizId");
        
        QuestionService questionService = new QuestionService();
        
        QuizService quizService = new QuizService();

        Quiz quiz = quizService.rechercheQuizz(id);

        String titre = req.getParameter("titre");
        byte order = Byte.parseByte(req.getParameter("ordre"));
        String rep1 = req.getParameter("rep1");
        String rep2 = req.getParameter("rep2");
        String rep3 = req.getParameter("rep3");
        String rep4 = req.getParameter("rep4");
        byte reponse = Byte.parseByte(req.getParameter("rep"));
        
        Question question = new Question();
        
        question.setTitre(titre);
        question.setOrdre(order);
        question.setRep1(rep1);
        question.setRep2(rep2);
        question.setRep3(rep3);
        question.setRep4(rep4);
        question.setNumRepCorrect(reponse);
        question.setQuiz(quiz);
        quiz.getQuestion().add(question);
        
        questionService.ajouterQuestion(question);
        
        resp.sendRedirect("liste_question");
    }
}
