package com.alekras.dto;

import lombok.*;

/**
 * \* @author AleKras on 28.12.2023
 * \* Description:
 * \*
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}