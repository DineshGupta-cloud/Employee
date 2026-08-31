package com.RestApi.Controller;

import com.RestApi.DTO.ProductDto;
import com.RestApi.Exception.ResourceNotFoundException;
import com.RestApi.Model.Employee;

import com.RestApi.Model.Product;
import com.RestApi.Repository.EmployeeRepository;
import com.RestApi.Repository.ProductRepository;
import com.RestApi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee) {

        if (employeeRepository.existsByFirstNameOrEmail(employee.getFirstName(), employee.getEmail())) {
            throw new RuntimeException("User  already exists with UserName or emailId");
        }

        Employee employee1 = employeeService.createNewEmployee(employee);

        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {


        Product product1 = employeeService.createNewProduct(product);

        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProduct() {

        List<ProductDto> productDtos = employeeService.getAllProduct();

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employeePage1")
    public Page<Employee> getAllEmployeesPage(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return employees;
    }

    @GetMapping("/employeePage")
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "empId") String sortBy) {
        List<Employee> list = employeeService.findAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }



    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee) {

        employee.setEmpId(empId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
//        return ResponseEntity.ok().body(employee);
    }

    // Build Delete User REST API
    @DeleteMapping("{empId}")
    public ResponseEntity<String> deleteUser(@PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}

