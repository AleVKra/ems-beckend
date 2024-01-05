package com.alekras.controller;

import com.alekras.dto.EmployeeDTO;
import com.alekras.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO saveEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDTO);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	@PostMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
	@RequestBody EmployeeDTO updatedEmployee){
		EmployeeDTO employeeDTO=employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDTO);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!.");
	}
}