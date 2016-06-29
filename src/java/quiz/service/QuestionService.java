/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.service;

import java.util.List;
import quiz.dao.QuestionDAO;
import quiz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    public void ajouterQuestion(Question q) {
        
        QuestionDAO dao = new QuestionDAO();
        
        dao.ajouter(q);
    }
    
    public List<Question> rechercheQuestion(long id) {
        
        QuestionDAO dao = new QuestionDAO();
        
        return dao.rechercheParQuizId(id);
    }
    
    public List<Question> rechercheQuestionOrdre(long id, byte ordre) {
        
        QuestionDAO dao = new QuestionDAO();
        
        return dao.rechercheParOrdre(id, ordre);
        
//        if (question.isEmpty()) {
//            return null;
//        } else {
//            return question;
//        }
    }
    
    public void supprimerQuestionParId(long qId) {
        
        new QuestionDAO().supprimerParId(qId);
    }
    
    public long nbTotalQuestion(long quizId) {
        
        return new QuestionDAO().CompteQuestionParQuizId(quizId);
    }
}
