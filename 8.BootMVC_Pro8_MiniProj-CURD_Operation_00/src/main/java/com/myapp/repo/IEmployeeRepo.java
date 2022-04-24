package com.myapp.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.myapp.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
