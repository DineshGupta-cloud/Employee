package com.RestApi.Service;

import com.RestApi.DTO.ProductDto;
import com.RestApi.Exception.ResourceNotFoundException;
import com.RestApi.Exception.UserAlreadyExists;
import com.RestApi.Mapper.ProductMapper;
import com.RestApi.Model.Employee;
import com.RestApi.Model.Product;
import com.RestApi.Repository.EmployeeRepository;
import com.RestApi.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProductRepository productRepository;


    private ModelMapper mapper;

    @Override
    public Employee createNewEmployee(Employee employee)  {

        Employee employee1 = employeeRepository.save(employee);

        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employee = employeeRepository.findAll();
        return employee;
    }

    @Override
    public List<Employee> findAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return  pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }

    @Override
    public Employee getEmployeeById(long id) throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " + id));
        return employee;
    }

    @Override
    public List<ProductDto> getAllProduct() {

        List<Product> product = productRepository.findAll();

        return product.stream().map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public Product createNewProduct(Product product) {

        Product product1=productRepository.save(product);
        return product1;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee existingEmployee=employeeRepository.findById(employee.getEmpId()).get();

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setMiddleName(employee.getMiddleName());
        existingEmployee.setEmail(employee.getEmail());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }


}
