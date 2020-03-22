package com.java.employee;

import javax.persistence.*;

@Entity
@Table(name="employee_table")
public class Employee
{
    @Id
    private int id;
    private EmployeeName name;
    private String dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeName getName() {
        return name;
    }

    public void setName(EmployeeName name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }


    public void setDept(String dept) {
        this.dept = dept;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", dept='" + dept + '\'' +
                '}';
    }
}
