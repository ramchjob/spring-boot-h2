package com.sq.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sq.learn.entities.Employee;
import com.sq.learn.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/emp")
@Api(value = "emp", description = "Employee Information")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepository;

	@ApiOperation(value = "list all Employees", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping()
	public List<Employee> getAllDepartments() {
		return empRepository.getAllEmployees();
	}

	@ApiOperation(value = "Get an Employee with empno", response = Employee.class)
	@GetMapping("/{empno}")
	public Employee getDeptById(@PathVariable Integer empno) {
		return empRepository.getByEmptNo(empno);
	}
	
 
    
    @ApiOperation(value = "Delete an Employee")
    @DeleteMapping(value = "/{empno}")
    public ResponseEntity<Object> dellDept(@PathVariable Integer empno){
    	empRepository.delEmpById(empno);
        return new ResponseEntity<Object>("Employee deleted successfully", HttpStatus.OK);
    }
    
 
	
}
