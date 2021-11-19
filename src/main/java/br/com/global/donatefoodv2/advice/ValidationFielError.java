package br.com.global.donatefoodv2.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFielError {
	private String field;
	private String error;

}
