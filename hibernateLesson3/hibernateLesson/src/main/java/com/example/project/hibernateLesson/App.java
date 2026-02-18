package com.example.project.hibernateLesson;

import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Titular t = (Titular) session.get(Titular.class, 5);
    	System.out.println(t.getNombre() + " " + t.getApellidos());
    	
    	/*
    	session.beginTransaction();
    	Titular nuevo = new Titular("Peter", "Frampton");
    	session.persist(nuevo);
    	
    	
    	session.getTransaction().commit();
    	session.close();
    	*/
    }
}
