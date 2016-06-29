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
        
        QuestionService questionService = new QuestionService();
        
        // Récupération des différents informations (score du jouer, ordre de la question actuel, id du quiz et la réponse du joueur)
        int score = (int) req.getSession().getAttribute("score");
        byte ordre = (byte) req.getSession().getAttribute("ordre");
        long idQuiz = (long) req.getSession().getAttribute("quizId");
        String reponse = req.getParameter("rep");
        
        req.setAttribute("nbTotalQuestion", questionService.nbTotalQuestion(idQuiz));

        // appel au service rechercheQuestionOrdre pour lister les questions
        List<Question> question = questionService.rechercheQuestionOrdre(idQuiz, ordre);

        // condition de comparaison de la réponse du joueur avec le bonne reponse que l'on va cherche en session
        if (reponse.equals(req.getSession().getAttribute("bonneRep").toString())) {
            score = score +1;
            req.getSession().setAttribute("score", score);
        }
        
        // Si la List est vide on redirige le joueur
        if (question.isEmpty()) {
//            throw new RuntimeException("Le quiz est vide!");
            resp.sendRedirect("score");
            
        } else {
            // Sinon
            
            // Attribution de la premiere question de la List dans quizQuestion
            req.setAttribute("quizQuestion", question.get(0));
            
            // initialise order qvec le nouvel ordre de la question suivante
            byte order = question.get(0).getOrdre();

            // mise en session du nouvel ordre de la question
            req.getSession().setAttribute("ordre", order);

            req.getRequestDispatcher("jouer_quiz.jsp").forward(req, resp);
            
        }
    }
}
