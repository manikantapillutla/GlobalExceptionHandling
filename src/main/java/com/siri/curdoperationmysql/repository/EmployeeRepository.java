package com.siri.curdoperationmysql.repository;

import com.siri.curdoperationmysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
