package com.java;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student
{
    @Id
    Integer id;
    String name;
    String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                '}';
    }
}
