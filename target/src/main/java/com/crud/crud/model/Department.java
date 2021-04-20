package com.crud.crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="Department")
@Getter
@Setter
@Entity
public class Department {
    @Id
    @Column
    Integer dept_id;
    @Column
    String dept_name;



    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}

