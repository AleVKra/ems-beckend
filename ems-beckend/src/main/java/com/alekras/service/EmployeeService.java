package com.alekras.service;

import com.alekras.dto.EmployeeDTO;

import java.util.List;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */
public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(Long employeeId);

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);

	void deleteEmployee(Long employeeId);
}