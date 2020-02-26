package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.model.Auto;
import com.model.User;

@EnableJpaRepositories
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!configuration = " + configuration);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!builder = " + builder);
                sessionFactory = configuration.buildSessionFactory(builder.build());
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!sessionFactory = " + sessionFactory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
