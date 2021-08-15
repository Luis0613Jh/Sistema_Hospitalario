package vista.utilidades;

import java.util.List;
import javax.swing.JComboBox;
import modelo.Persona;

public class UtilidadesVista {

    /**
     * Método que permite cargar objetos de tipo Persona en un combobox.
     * @param cbx Combobox en el que se va a cargar los objetos de tipo Persona.
     * @param objetos Lista de objetos de tipo Persona que se van a cargar.
     */
    public static void cargarCbxPersonas(JComboBox cbx, List<Persona> personas) {
        cbx.removeAllItems();
        for (Persona persona : personas) {
            cbx.addItem(persona);
        }
    }

    /**
     * Método que permite cargar objetos en un combobox.
     * @param cbx Combobox en el que se va a cargar los objetos de la lista.
     * @param objetos Lista de objetos que se van a cargar .
     */
    public static void cargarCbx(JComboBox cbx, List<Object> objetos) {
        cbx.removeAllItems();
        for (Object objeto : objetos) {
            cbx.addItem(objeto);
        }
    }
}
