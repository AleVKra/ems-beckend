package com.alekras.service;

import com.alekras.dto.EmployeeDTO;
import com.alekras.entity.Employee;
import com.alekras.exception.ResourceNotFoundException;
import com.alekras.mapper.EmployeeMapper;
import com.alekras.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeRepository employeRepository;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee saveEmployee = employeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(saveEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {

		Employee employee = employeRepository.findById(employeeId)
			.orElseThrow(() ->
				new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeRepository.findAll();

		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
			.collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
		Employee employee = employeRepository.findById(employeeId).orElseThrow(
			() -> new ResourceNotFoundException("Employee is not exists given id: " + employeeId)
		);

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeRepository.findById(employeeId).orElseThrow(
			() -> new ResourceNotFoundException("Employee is not exists given id: " + employeeId)
		);

		employeRepository.deleteById(employeeId);
	}
}