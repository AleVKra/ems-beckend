package com.alekras.mapper;

import com.alekras.dto.EmployeeDTO;
import com.alekras.entity.Employee;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */

public class EmployeeMapper {
	public static EmployeeDTO mapToEmployeeDto(Employee employee) {
		return new EmployeeDTO(
			employee.getId(),
			employee.getFirstName(),
			employee.getLastName(),
			employee.getEmail()
		);
	}

	public static Employee mapToEmployee(EmployeeDTO employeeDTO){
		return new Employee(
			employeeDTO.getId(),
			employeeDTO.getFirstName(),
			employeeDTO.getLastName(),
			employeeDTO.getEmail()
		);
	}
}