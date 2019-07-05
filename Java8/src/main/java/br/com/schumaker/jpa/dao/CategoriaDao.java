package br.com.schumaker.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.schumaker.jpa.model.Categoria;

/**
 *
 * @author hudson schumaker
 */
@Repository
public class CategoriaDao {

    @PersistenceContext
    private EntityManager em;

    public List<Categoria> getCategorias() {
        TypedQuery<Categoria> query = em.createQuery("from Categoria", Categoria.class);
        return query.getResultList();
    }
}
