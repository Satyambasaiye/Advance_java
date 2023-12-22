package com.app.service;

import java.util.List;

import com.app.dto.AuthRequestDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.entities.Employee;

public interface EmployeeService {
	List<EmployeeRespDTO> getAllEmps();

	Employee addEmpDetails(Employee newEmp);

	String deleteEmpDetails(Long empId);

	Employee getEmpDetails(Long empId);

	Employee updateEmpDetails(Employee emp);

	EmployeeRespDTO authenticateEmployee(AuthRequestDTO request);

	// get all emps : pagination
	List<EmployeeRespDTO> getAllEmployees(int pageNumber, int pageSize);

}
