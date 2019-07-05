/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.jpa;

import br.com.schumaker.jpa.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hudsonschumaker
 */
public class TesteLockPessimista {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfigurator.class);
        EntityManagerFactory factory = context.getBean(EntityManagerFactory.class);

        EntityManager em1 = factory.createEntityManager();
        EntityManager em2 = factory.createEntityManager();

        em1.getTransaction().begin();
        em2.getTransaction().begin();

        Produto produtoDoEM1 = em1.find(Produto.class, 1);
        em1.lock(produtoDoEM1,LockModeType.PESSIMISTIC_WRITE);

        produtoDoEM1.setNome("Maria");    

        Produto produtoDoEM2 = em2.find(Produto.class, 1);
        em2.lock(produtoDoEM2, LockModeType.PESSIMISTIC_WRITE);    
    }
}
