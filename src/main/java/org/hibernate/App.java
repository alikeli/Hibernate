package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.model.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new org.hibernate.cfg.Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person1 = new Person("Test 1", 15);
            Person person2 = new Person("Test 2", 25);
            Person person3 = new Person("Test 3", 35);
            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
