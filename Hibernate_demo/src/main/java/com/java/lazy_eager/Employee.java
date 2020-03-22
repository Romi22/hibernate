package com.java.lazy_eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Employee
{

    @Id
    Integer id;
    String name;

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
//@OneToMany(mappedBy = "employee")
    private Collection<Laptop> laptops=new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Collection<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
