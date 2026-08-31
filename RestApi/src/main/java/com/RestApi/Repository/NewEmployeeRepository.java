package com.RestApi.Repository;

import com.RestApi.Model.NewEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEmployeeRepository extends JpaRepository<NewEmployee,Long> {
}
