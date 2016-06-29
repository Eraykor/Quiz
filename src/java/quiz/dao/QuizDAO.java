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
import quiz.entity.Quiz;

/**
 *
 * @author admin
 */
public class QuizDAO {
    
    public void ajouter(Quiz q) {
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(q);
        
        em.getTransaction().commit();
    }
    
    public Quiz rechercheParId(long id) { 
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        return (Quiz) em.createQuery("SELECT q FROM Quiz q WHERE q.id=:QzId").setParameter("QzId", id).getSingleResult();
    }

    public List<Quiz> lister() {
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        return em.createQuery("SELECT q FROM Quiz q").getResultList();
    }

    public void supprimerQuizActu(long quizId) {
        
        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("DELETE FROM Question q WHERE q.quiz.id=:idQuiz");
        query.setParameter("idQuiz", quizId);
        query.executeUpdate();
        
        Query query1 = em.createQuery("DELETE FROM Quiz q WHERE q.id=:idQuiz");
        query1.setParameter("idQuiz", quizId);
        query1.executeUpdate();
        
        em.getTransaction().commit();
    }
//    
//    public void supprimerQuizQuestion(long quizId) {
//        
//        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
//        
//        
//    }
}
