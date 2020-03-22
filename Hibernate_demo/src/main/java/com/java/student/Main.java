package com.java.student;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");


        Laptop l=new Laptop();
        l.setId(111);
        l.setName("Xiomi");

        Student s=new Student();
        s.setRollno(10);
        s.setName("Sonam");
        s.setMarks("78");
        s.getLaptop().add(l);

        l.getStudent().add(s);

        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        session.save(l);
        session.save(s);

        tx.commit();

    }
}
