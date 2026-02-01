package com.siri.curdoperationmysql.service;

import com.siri.curdoperationmysql.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    public Employee addEmployee(Employee emp);

    public Employee getEmpById(Long empidL);

    public List<Employee> getAllEmployee();

    public void deleteEmpById(Long empidL);
}
