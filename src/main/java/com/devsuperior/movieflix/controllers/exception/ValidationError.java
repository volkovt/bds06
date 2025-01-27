package com.devsuperior.movieflix.controllers.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 8927789002501005457L;
	
	private List<FieldMessage> erros = new ArrayList<>();

	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
}
