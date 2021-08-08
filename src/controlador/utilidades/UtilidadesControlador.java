package controlador.utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UtilidadesControlador {

    public static boolean validarNumeroEntero(String numero) {
        return numero.matches("^[0-9]+$");
    }

    public static boolean validarCadena(String cadena) {
        return cadena.matches("^([A-Za-z]+[ ]?)+$");
    }

    public static boolean validarNombre(String nombre) {
        return nombre.matches("^(([A-Za-z]{1})?[a-z]+[ ]?)+$");
    }

    public static boolean validarCedula(String cedula) {
        return cedula.matches("^[0-9]{10}$");
    }

    public static int determinarEdad(String fechaNacimientoString) {
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, fechaFormato);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        return edad.getYears();
    }
}
