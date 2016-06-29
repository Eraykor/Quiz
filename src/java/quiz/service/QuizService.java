/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.service;

import java.util.List;
import quiz.dao.QuizDAO;
import quiz.entity.Quiz;

/**
 *
 * @author admin
 */
public class QuizService {
    
    public void ajouter(Quiz q) {
        
        QuizDAO dao = new QuizDAO();
        
        dao.ajouter(q);
    }
    
    public Quiz rechercheQuizz(long id) {
        
        return new QuizDAO().rechercheParId(id);
    }
    
    public List<Quiz> listerQuiz() {
        
        QuizDAO dao = new QuizDAO();
        
        return dao.lister();
    }
    
    public void supprimerQuiz(long quizId) {
        
        QuizDAO dao = new QuizDAO();

        dao.supprimerQuizActu(quizId);
        
    }
    
    public void supprimerQuestion(long quizId) {
        
        QuizDAO dao = new QuizDAO();
        
        dao.supprimerQuizQuestion(quizId);
        
    }

}
