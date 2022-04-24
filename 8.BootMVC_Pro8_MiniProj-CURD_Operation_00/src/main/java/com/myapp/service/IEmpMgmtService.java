package com.myapp.service;

import com.myapp.model.Employee;

public interface IEmpMgmtService {
public Iterable<Employee> getAllEmployees();
public String insertEmployee(Employee emp);
public Employee getEmployeeByno(int eno);
public String updateEmployee(Employee emp);
public String deleteEmployeeByEno(int eno);
}
