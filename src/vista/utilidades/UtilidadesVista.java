
package vista.utilidades;

import java.util.List;
import javax.swing.JComboBox;

public class UtilidadesVista {
    
    public static void cargarCbx(JComboBox cbx, List<Object> objetos){
        cbx.removeAllItems();
        for (Object objeto : objetos) {
            cbx.addItem(objeto);
        }
    }
}
