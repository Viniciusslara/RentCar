/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

/**
 *
 * @author Gabriel
 */
public class StringValidators {
public static boolean isNumeric(String str) {
    if (str == null || str.length() == 0) {
        return false;
    }
    for (char c : str.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}
    
    public static boolean isCPFValido(String cpf) {
    // Verifica se a string do CPF é nula ou tem tamanho inválido
    if (cpf == null || cpf.length() != 11) {
        return false;
    }
    
    // Verifica se todos os dígitos do CPF são iguais
    boolean todosIguais = true;
    for (int i = 1; i < cpf.length(); i++) {
        if (cpf.charAt(i) != cpf.charAt(0)) {
            todosIguais = false;
            break;
        }
    }
    if (todosIguais) {
        return false;
    }
    
    // Verifica os dígitos verificadores do CPF
    int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));
    int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1);
    return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
}

private static int calcularDigitoVerificador(String parteCPF) {
    int soma = 0;
    for (int i = 0; i < parteCPF.length(); i++) {
        int digito = Character.getNumericValue(parteCPF.charAt(i));
        soma += digito * (parteCPF.length() + 1 - i);
    }
    int resto = 11-(soma % 11);
    if (resto > 9) {
        return 0;
    } else {
        return resto;
    }
}

public static boolean isVazio(String str) {
    return str.isEmpty();
}
 
}
