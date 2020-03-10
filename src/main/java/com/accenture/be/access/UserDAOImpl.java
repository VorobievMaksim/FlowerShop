package com.accenture.be.access;

import com.accenture.be.entity.User;
import com.accenture.be.exeptions.FlowerShopErrors;
import com.accenture.be.exeptions.FlowerShopExeptions;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.swing.text.html.parser.Entity;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getByUsername(String username) throws FlowerShopExeptions {
        User user;
        try {
            TypedQuery<User> query  = entityManager.createNamedQuery("User.findByUsername", User.class).setParameter("username",username);
            user = query.getSingleResult();
            return user;
        } catch (NoResultException nr) {
            return null;
        }
    }

    @Override
    public User getByID(Long ID) {
        User user;
        try {
            TypedQuery<User> query  = entityManager.createNamedQuery("User.findById", User.class).setParameter("id",ID);
            user = query.getSingleResult();
            return user;
        } catch (NoResultException nr) {
            return null;
        }
    }

    @Override
    public List<User> getListUsers() {
        List<User> users;
        try {
            TypedQuery<User> query  = entityManager.createNamedQuery("User.findAll", User.class);
            users = query.getResultList();
        } catch (NoResultException nr) {
            users = Collections.emptyList();
        }
        return users;
    }
}
