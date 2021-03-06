package com.webApp.app.daos;

import com.webApp.app.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by knery on 27/06/17.
 */

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Product product) {
        manager.persist(product);
    }

    public List<Product> list() {
        return manager.createQuery("select distinct(p) from Product p join fetch p.prices", Product.class).getResultList();
    }


    public Product find(Integer id) {

        TypedQuery<Product> query = manager.createQuery("select distinct(p) from Product p join fetch p.prices where p.id=:id", Product.class).setParameter("id", id);

        return query.getSingleResult();
    }
}
