package com.alekras.entity;

import lombok.*;

import javax.persistence.*;

/**
 * \* @author AleKras on 27.12.2023
 * \* Description:
 * \*
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id", nullable = false, unique = true)
	private String email;
}