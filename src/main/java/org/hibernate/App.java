package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.model.Person;

import java.util.List;

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

//            Person person3 = new Person("Some name", 30);
//            session.save(person3);
//
//            List<Person>people = session.createQuery("FROM Person where name = 'Test 1'").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }
//
//            List<Person>people1= session.createQuery("FROM Person where age > 15 ").getResultList();
//            for (Person person : people1) {
//                System.out.println(person);
//            }

//            List<Person>people2= session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
//            for (Person person : people2) {
//                System.out.println(person);
//            }

          session.createQuery("UPDATE Person set name = 'Tom' where age > 30").executeUpdate();

            List<Person>people= session.createQuery("FROM Person ").getResultList();
            for (Person person : people) {
                System.out.println(person);
            }
            System.out.println();
            session.createQuery("DELETE Person where age < 20").executeUpdate();

            List<Person>people1= session.createQuery("FROM Person ").getResultList();
            for (Person person : people1) {
                System.out.println(person);
            }




            session.getTransaction().commit();

            //System.out.println(person3.getId());
        } finally {
            sessionFactory.close();
        }
    }
}
