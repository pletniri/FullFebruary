package com.Month.FullFebruary.Repository.Entity;

import com.Month.FullFebruary.Controller.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String position;

    private String image;

    public Employee() {
    }

    public Employee(Integer id, String name, String position, String image) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.image = image;
    }

    public Employee(EmployeeDto employeeDto) {
        this.name = employeeDto.getName();
        this.position = employeeDto.getPosition();
        this.image = employeeDto.getImage();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
