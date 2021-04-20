package com.crud.crud.repository;

import com.crud.crud.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository  extends CrudRepository<Department, Integer> {
}
