package com.crud.crud.controller;

import com.crud.crud.model.Department;
import com.crud.crud.model.EmpDept;
import com.crud.crud.model.Employee;
import com.crud.crud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Random;

@RestController
class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    Random random= new Random();


    @GetMapping(path = "/employee")
    private List<Employee>  getAllEmployee()
    {
        System.out.println("Started getAllEmployee :");
        return  employeeService.getAllEmployee();
    }

    @GetMapping(path = "employee/{employee_id}")
    private Employee getEmployeeById(@PathVariable("employee_id") Integer id )
    {
        System.out.println("Started getEmployeeById :");
        return   employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/employee")
    private int saveEmployee(@RequestBody  Employee employee)
    {

        System.out.println("Started saveEmployee :");
//        int id=random.nextInt();
//        employee.setEmploye_id(id);
        employeeService.saveUpdateEmployee(employee);
       System.out.println("Added Employee id:"+employee.getEmploye_id());
        return employee.getEmploye_id();
    }

    @PutMapping(path = "/employee/{employee_id}")
    private  void deleteEmplpoyee(@PathVariable("employee_id") int id)
    {
        System.out.println("Started deleteEmplpoyee :");
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/dept")
    private void saveDept(@RequestBody Department dept)
    {
        employeeService.saveUpdateDept(dept);
    }

    @GetMapping("/dept/{deptId}")
    private  Department getDept(@PathVariable Integer deptId)
    {
         return employeeService.getDept(deptId);
    }

    @GetMapping("/empldept/{id}")
   private List<EmpDept> getEmpDept(Integer id)
    {
        return employeeService.getEmpDept();
    }

}

