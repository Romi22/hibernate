package com.java.employee;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");

        EmployeeName emp=new EmployeeName();
        emp.setFirstName("Deepa");
        emp.setMiddleName("Kumari");
        emp.setLastName("Singh");

        Employee employee = new Employee();

        employee.setId(101);
        employee.setDept("FAWB");
        employee.setName(emp);

        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);

      // ServiceRegistry  reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        session.save(employee);

       // employee = session.get(Employee.class,102);

        tx.commit();

        //System.out.println(employee);
    }
}
