package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotNull(message = "username should not be null")
	private String userName;
	//@Pattern(regexp = "[0-9]{10}[A-Z]{1}",message = "password is not valid")
	private String password;
	@NotNull(message="role should not be null")
	private String role;
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderInfo")
	private List<Order> allOrders;	*/
	public User(@NotNull(message = "username should not be null") String userName, String password,
			@NotNull(message = "role should not be null") String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

}
