package com.RestApi.Service;

import com.RestApi.DTO.ProductDto;
import com.RestApi.Exception.ResourceNotFoundException;
import com.RestApi.Model.Employee;
import com.RestApi.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {

    Employee createNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> findAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

    Employee getEmployeeById(long id) throws ResourceNotFoundException;


     List<ProductDto> getAllProduct();

     Product createNewProduct(Product product);

     Employee updateEmployee(Employee employee);

     void deleteEmployee(Long empId);
}
