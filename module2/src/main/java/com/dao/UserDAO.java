package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.model.Auto;
import com.model.User;
import com.utils.HibernateSessionFactoryUtil;

import java.util.List;
// Hibernate test
public class UserDAO {
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        System.out.println("session = " + HibernateSessionFactoryUtil.getSessionFactory());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From" + User.class.getSimpleName()).list();
        return users;
    }

    public User findUserByName(String name) {
        User user = (User)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From" + User.class.getName());
        return user;
    }

}
