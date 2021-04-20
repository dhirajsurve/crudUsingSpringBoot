package com.crud.crud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Employee")
@Getter
@Setter
@Data
@ToString
public class Employee {
    @Id
    @Column
    Integer employe_id;
    @Column
    String employe_name;
    @Column
    int age;

    @Column
    String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dept_id_fk",referencedColumnName = "dept_id")
    private Department department;


    public Integer getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(Integer employe_id) {
        this.employe_id = employe_id;
    }

    public String getEmploye_name() {
        return employe_name;
    }

    public void setEmploye_name(String employe_name) {
        this.employe_name = employe_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employe_id=" + employe_id +
                ", employe_name='" + employe_name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", department=" + department +
                '}';
    }
}
