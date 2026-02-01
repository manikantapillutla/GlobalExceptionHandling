package com.siri.curdoperationmysql.service;

import com.siri.curdoperationmysql.custom.exception.BusinessException;
import com.siri.curdoperationmysql.custom.exception.EmptyInputException;
import com.siri.curdoperationmysql.model.Employee;
import com.siri.curdoperationmysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee emp) {

            if(emp.getName().isEmpty() || emp.getName().length()==0){
                throw new EmptyInputException("601","Input Fields are empty");
            }
            Employee savedEmployee = employeeRepository.save(emp);
            return savedEmployee;

    }

    @Override
    public Employee getEmpById(Long empidL) {
            return employeeRepository.findById(empidL).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
            List<Employee> empList=employeeRepository.findAll();
            if(empList.isEmpty())
                throw  new BusinessException("604","Hey list is completely empty , we have nothing");
            return empList;
    }

    @Override
    public void deleteEmpById(Long empidL) {
       employeeRepository.deleteById(empidL);
    }


}
