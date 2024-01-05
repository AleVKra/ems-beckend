package com.alekras.repository;

import com.alekras.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */

public interface EmployeRepository extends JpaRepository<Employee, Long> {
//	void delete(Long employeeId);
}