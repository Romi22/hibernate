package com.java.student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student
{
    @Id
    Integer rollno;
    String name;
    String marks;

//    @OneToOne
//    private Laptop laptop;

//    @OneToMany(mappedBy = "student")
//    //mappedBy no separate table will be created i.e. student_laptop
//    private List<Laptop> laptop=new ArrayList<>();

    //i.e. mapping will be done by the laptop
    @ManyToMany(mappedBy="student")
    private List<Laptop> laptop=new ArrayList<>();

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    public Integer getRollno() {
        return rollno;
    }
    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks+
                '}';
    }
}
