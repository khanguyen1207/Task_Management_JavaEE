package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by khanguyen on 24/01/2017.
 */
@Repository
@Qualifier("bean")
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
    public Employee findById(long id);
}
