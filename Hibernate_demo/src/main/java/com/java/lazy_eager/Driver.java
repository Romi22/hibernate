package com.java.lazy_eager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class Driver
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");

        Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class);

        // ServiceRegistry  reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

       session.beginTransaction();

         Employee employee1 =  session.get(Employee.class,1);

        System.out.println(employee1);

        Collection<Laptop> lapii=employee1.getLaptops();

        for(Laptop l:lapii)
            System.out.println(l);

        session.getTransaction().commit();

    }
}
