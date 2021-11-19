package br.com.global.donatefoodv2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A Razão Social é obrigatório")
	private String corporate;

	@NotBlank(message = "O CNPJ é obrigatório")
	private String cnpj;

	@NotBlank(message = "O e-mail é obrigatório")
	private String email;

	@NotBlank(message = "A quantidade é obrigatório")
	private String quantity;

	@NotBlank(message = "O produto é obrigatório")
	private String product;

	@NotBlank(message = "O contato é obrigatório")
	private String contact;

}
