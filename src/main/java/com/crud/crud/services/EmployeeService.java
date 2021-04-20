package com.crud.crud.services;

import com.crud.crud.model.Department;
import com.crud.crud.model.EmpDept;
import com.crud.crud.model.Employee;
import com.crud.crud.repository.DeptRepository;
import com.crud.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DeptRepository deptRepository;

    Random random= new Random();

    public List<Employee> getAllEmployee()
    {
        List<Employee> employeesList= new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employeesList.add(employee));
        return employeesList;
    }

    public  Employee getEmployeeById(Integer id)
    {
        return   employeeRepository.findById(id).get();
    }

    public  void saveUpdateEmployee(Employee emp)
    {



        employeeRepository.save(emp);
    }

    public  void deleteEmployee(Integer id)
    {
        employeeRepository.deleteById(id);
    }

    public  void saveUpdateDept(Department dept)
    {

        deptRepository.save(dept);
    }

    public Department getDept(Integer deptId)
    {
     return    deptRepository.findById(deptId).get();
    }

    public List<EmpDept> getEmpDept(){
        List<EmpDept> empDeptList=employeeRepository.fetchEmpDeptInner();
        empDeptList.forEach(emp->System.out.println(emp));
        return  empDeptList;
    }


}
