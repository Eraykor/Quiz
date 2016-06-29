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
import quiz.service.QuestionService;

/**
 *
 * @author admin
 */
@WebServlet(name = "SupprimerQuestionParIdServlet", urlPatterns = {"/supprimer_by_id"})
public class SupprimerQuestionParIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long qId = Long.parseLong(req.getParameter("qId"));
        
        QuestionService questionService = new QuestionService();
        
        questionService.supprimerQuestionParId(qId);
        
        resp.sendRedirect("liste_question");
    }
}
