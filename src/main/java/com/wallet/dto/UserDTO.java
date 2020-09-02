package com.wallet.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	@Email(message = "Formato de Email inválido")
	private String email;
	@NotBlank
	@Length(min = 3, max = 50, message = "O nome deve conter de 3 a 50 caracteres")
	private String name;
	
	@NotBlank
	@Length(min = 6, message = "O Password deve conter pelo meno seis caracteres")
	private String password;
}
