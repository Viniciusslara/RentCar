/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

/**
 *
 * @author Gabriel
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
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
 public static boolean isDateValid(String dateStr) {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date currentDate = new Date();
    try {
        Date date = dateFormat.parse(dateStr);
        if (date.after(currentDate)) {
            return false;
        }
    } catch (ParseException e) {
        return false;
    }
    return true;
}
 
 public static boolean is18YearsOld(String dateStr) {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date birthDate = dateFormat.parse(dateStr);
        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        dob.add(Calendar.DAY_OF_MONTH, 1);
        int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age >= 18;
    } catch (ParseException e) {
        return false;
    }
}
}
