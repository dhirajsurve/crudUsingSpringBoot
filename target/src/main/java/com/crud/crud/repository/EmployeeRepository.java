package com.crud.crud.repository;

import com.crud.crud.model.EmpDept;
import com.crud.crud.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


    @Query("Select new com.crud.crud.model.EmpDept(d.dept_id)"+ "FROM Employee e INNER JOIN e.department d")
    List<EmpDept> fetchEmpDeptInner();
}
