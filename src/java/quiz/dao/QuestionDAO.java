/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import quiz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionDAO {
    
    public void ajouter(Question q) {
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(q);
        
        em.getTransaction().commit();
    }
    
    public List<Question> rechercheParQuizId(long quizId) { 
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        return (List<Question>) em.createQuery("SELECT q FROM Question q WHERE q.quiz.id=:QId").setParameter("QId", quizId).getResultList();
    }
    
    public List<Question> rechercheParOrdre(long quizId, byte ordre) { 
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();

        Query query = em.createQuery("SELECT q FROM Question q WHERE q.quiz.id=:QId AND q.ordre >:order ORDER BY q.ordre");
        query.setParameter("QId", quizId);
        query.setParameter("order", ordre);

        return (List<Question>) query.getResultList();
    }
}
