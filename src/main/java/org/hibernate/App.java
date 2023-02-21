package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.model.Item;
import org.hibernate.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
// show people's items
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);


            //--------------------------
            //show item's people
//            Item item = session.get(Item.class, 5);
//            Person person = item.getOwner();
//            System.out.println(person);
            //--------------------------
            //add items
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate4", person);
//            person.getItems().add(newItem);
//
//            session.save(newItem);

            //--------------------------
            //add people and his item

//            Person person = new Person("Test", 24);
//            Item newItem = new Item("new Item", person);
//
//            person.setItems(new ArrayList<>(Collections.singleton(newItem)));
//            session.save(person);
//            session.save(newItem);
            //--------------------------
            // delete items by id

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
//            for (Item item : items) {
//                session.remove(item);
//
//            }
//            person.getItems().clear();
//
//
            // delete person

            Person person = session.get(Person.class, 2);
            session.remove(person);

            person.getItems().forEach(item -> item.setOwner(null));

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
