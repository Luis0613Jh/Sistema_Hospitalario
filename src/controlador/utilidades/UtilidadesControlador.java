package controlador.utilidades;

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

}
