package br.com.ec.calculadora;

import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ec.calculadora.exception.InvalidParameterException;
import br.com.ec.calculadora.exception.NoResourceFoundException;

@RestController
public class MathController {

	// Método para tratar a chamada sem parâmetros
	@GetMapping("/sum")
	public void sumWithoutParameters() {
		throw new NoResourceFoundException("Os parâmetros numberOne e numberTwo são obrigatórios.");
	}

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {

		// Verifica se os parâmetros foram fornecidos
		if (numberOne == null || numberTwo == null) {
			throw new NoResourceFoundException("Os parâmetros numberOne e numberTwo são obrigatórios.");
		}

		// Substitui vírgula por ponto para facilitar a conversão
		numberOne = numberOne.replace(',', '.');
		numberTwo = numberTwo.replace(',', '.');

		// Validador para verificar se as strings podem ser convertidas para double
		DoubleValidator validator = DoubleValidator.getInstance();

		// Validação das strings
		if (!validator.isValid(numberOne)) {
			throw new InvalidParameterException("O primeiro parâmetro não é um número válido: " + numberOne);
		}
		if (!validator.isValid(numberTwo)) {
			throw new InvalidParameterException("O segundo parâmetro não é um número válido: " + numberTwo);
		}

		// Conversão das strings para double
		double num1 = Double.parseDouble(numberOne);
		double num2 = Double.parseDouble(numberTwo);

		// Retorno da soma
		return num1 + num2;
	}
}
