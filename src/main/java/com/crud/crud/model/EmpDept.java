package com.crud.crud.model;

public class EmpDept {


    Employee employee;



    Department department;

    public EmpDept(Integer id) {
        this.department.setDept_id(id); ;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmpDept{" +
                "employee=" + employee.toString() +
                ", department=" + department.toString() +
                '}';
    }

}
