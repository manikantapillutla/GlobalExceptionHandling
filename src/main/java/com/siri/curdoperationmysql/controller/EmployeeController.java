package com.siri.curdoperationmysql.controller;


import com.siri.curdoperationmysql.custom.exception.BusinessException;
import com.siri.curdoperationmysql.custom.exception.ControllerException;
import com.siri.curdoperationmysql.model.Employee;
import com.siri.curdoperationmysql.service.EmployeeService;
import com.siri.curdoperationmysql.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {
    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp){
            Employee empSaved=employeeServiceInterface.addEmployee(emp);
            return new ResponseEntity<Employee>(empSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> listOfAllEmps=employeeServiceInterface.getAllEmployee();
        return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<?> getEmpById(@PathVariable("empid") Long empidL){
           Employee EmpRetrieved = employeeServiceInterface.getEmpById(empidL);
           return new ResponseEntity<Employee>(EmpRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL){
        employeeServiceInterface.deleteEmpById(empidL);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeServiceInterface.addEmployee(emp), HttpStatus.CREATED);
    }


}
