package vista.utilidades;

import java.util.List;
import javax.swing.JComboBox;
import modelo.Persona;

public class UtilidadesVista {

    public static void cargarCbxPersonas(JComboBox cbx, List<Persona> personas) {
        cbx.removeAllItems();
        for (Persona persona : personas) {
            cbx.addItem(persona);
        }
    }

    public static void cargarCbx(JComboBox cbx, List<Object> objetos) {
        cbx.removeAllItems();
        for (Object objeto : objetos) {
            cbx.addItem(objeto);
        }
    }
}
