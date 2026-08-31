package com.RestApi.Repository;

import com.RestApi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long > {

    Boolean existsByFirstName(String firstName);
    boolean existsByFirstNameOrEmail(String firstName, String email);

}
