package com.sq.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sq.learn.entities.Dept;
import com.sq.learn.repository.DeptRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/dept")
@Api(value = "dept", description = "Department Information")
@RestController
public class DeptController {

	@Autowired
	DeptRepository deptRepository;

	@ApiOperation(value = "list all Departments", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping
	public List<Dept> getAllDepartments() {
		return deptRepository.getAllDept();
	}

	@ApiOperation(value = "Get a Department with DEPTNO", response = Dept.class)
	@GetMapping(value = "/{deptno}")
	public Dept getDeptById(@PathVariable Integer deptno) {
		return deptRepository.getByDeptNo(deptno);
	}
	
    @ApiOperation(value = "Add a Department")
    @PostMapping
    public ResponseEntity<Object> addDept(@RequestBody Dept dept){
        deptRepository.addDept(dept);
        return new ResponseEntity<Object>("Department saved successfully", HttpStatus.OK);
    }
    
    @ApiOperation(value = "Delete a Department")
    @DeleteMapping("/{deptno}")
    public ResponseEntity<Object> dellDept(@PathVariable Integer deptno){
        deptRepository.delDeptById(deptno);
        return new ResponseEntity<Object>("Department deleted successfully", HttpStatus.OK);
    }
    
    @ApiOperation(value = "Update a Department")
    @PutMapping
    public ResponseEntity<Object> updateDept(@RequestBody Dept dept){
    	deptRepository.update(dept);
        return new ResponseEntity<Object>("Department updated successfully", HttpStatus.OK);
    }
	
}
