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
@WebServlet(name = "ChangeQuizActuelServlet", urlPatterns = {"/change_quiz_actuel"})
public class ChangeQuizActuelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        QuizService service = new QuizService();
        
        long quuizId = Long.parseLong( req.getParameter("quizId") );
        
        Quiz q = service.rechercheQuizz(quuizId);
        
        // Place quizId et quizNom en session
        req.getSession().setAttribute("quizId", q.getId());
        req.getSession().setAttribute("quizNom", q.getNom());
        
        // Redirice vers liste question servlet
        resp.sendRedirect("liste_question");
    }

    
}
