package com.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);

        // ServiceRegistry  reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

        session.beginTransaction();

//        Query q=session.createQuery("from Student where id=2");

     //   List<Student> students= q.list();

//        for(Student s:students)
//        {
//            System.out.println(s);
//        }

//        Query q=session.createQuery("select id,name,dept from Student where id=2");

      //  Query q=session.createQuery("from Student where id=2");

        Query q=session.createQuery("select id,name,dept from Student");
       List<Object[]> students= (List<Object[]>) q.list();

        //System.out.println(student);

//        for(Object o:student)
//            System.out.println(o);

        for(Object[] student:students)
        System.out.println(student[0]+":"+student[1]+":"+student[2]);

        session.getTransaction().commit();

    }
}
