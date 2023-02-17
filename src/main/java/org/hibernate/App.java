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

//            Person person = session.get(Person.class, 2);
//            person.setName("New name2");
//            Person person1 = session.get(Person.class, 5);
//            session.delete(person1);

            Person person3 = new Person("Some name", 30);
            session.save(person3);



            session.getTransaction().commit();

            System.out.println(person3.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
