package com.myapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myapp.model.Employee;
import com.myapp.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtImpl implements IEmpMgmtService {

    @Autowired
    private IEmployeeRepo empRepo;
    @Override
    public Iterable<Employee> getAllEmployees() {
	
//	return empRepo.findAll(Sort.by("job").ascending());
	return empRepo.findAll(Sort.by(Sort.Direction.ASC, "job"));
    }
    @Override
    public String insertEmployee(Employee emp) {
	
	return "employye inserted with value "+empRepo.save(emp).getEmpno();
    }
    @Override
    public Employee getEmployeeByno(int eno) {
	return empRepo.findById(eno).get();
    }
    @Override
    public String updateEmployee(Employee emp) {
	return empRepo.save(emp).getEmpno()+"Employee updated";
    }
    @Override
    public String deleteEmployeeByEno(int eno) {
	empRepo.deleteById(eno);
	return eno+" Employee deleted";
    }

}
