package com.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

public class CRUD
{
    protected SessionFactory sessionFactory;

    private void config() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }


    private void create() {
        Employee employee = new Employee();
        employee.setName("Romi");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }

    private void read() {
        Session session = sessionFactory.openSession();
        System.out.println(session.createQuery("FROM Employee").list());
        session.close();
    }

    private void update() {
        Employee employee = new Employee();
        employee.setName("Rohan");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee oldEmployee = (Employee) session.load(Employee.class, 4);
        oldEmployee.setName(employee.getName());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + oldEmployee);
    }

    private void delete() {
        Employee employee= new Employee();
        employee.setId(2);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    private void exit() {
        sessionFactory.close();
    }

    public void performOperations() {
        Scanner sc = new Scanner(System.in);
        config();
        while(true) {
            int option;
            System.out.println("Enter your choice : ");
            System.out.println("1. Create \n 2. read\n 3. Update\n 4. Delete");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    exit();
                    return;
            }
        }
    }
}