package com.accenture.be.access;

import com.accenture.be.entity.Flower;
import com.accenture.be.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class FlowerDAOImpl implements FlowerDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Flower> getListFlowers() {
        List<Flower> flowers;
        try {
            TypedQuery<Flower> query  = entityManager.createNamedQuery("Flower.findAll", Flower.class);
            flowers = query.getResultList();
        } catch (NoResultException nr) {
            flowers = Collections.emptyList();
        }
        return flowers;
    }

    @Override
    public Flower save(Flower flower) {
        entityManager.persist(flower);
        return flower;
    }

    @Override
    public Flower update(Flower flower) {
        return entityManager.merge(flower);
    }

    @Override
    public List<Flower> getByName(String name) {
        List<Flower> flowers;
        try {
            TypedQuery<Flower> query = entityManager.createNamedQuery("Flower.findByName", Flower.class).setParameter("name", name);
            flowers = query.getResultList();
        } catch (NoResultException nr) {
            flowers = Collections.emptyList();
        }
        return flowers;
    }


    @Override
    public  List<Flower> getByPrice(Double minPrice, Double maxPrice) {
        List<Flower> flowers;
        try {
            TypedQuery<Flower> query = entityManager.createNamedQuery("Flower.findByPrice", Flower.class).setParameter("min", minPrice).setParameter("max",maxPrice);
            flowers = query.getResultList();
        } catch (NoResultException nr) {
            flowers = Collections.emptyList();
        }
        return flowers;
    }
}
