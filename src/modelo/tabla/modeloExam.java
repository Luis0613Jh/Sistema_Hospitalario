/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabla;

import controlador.DAO.ExamenDAO;
import javax.swing.table.AbstractTableModel;
import modelo.Examen;

/**
 *
 * @author Jean Agreda
 */
public class modeloExam extends AbstractTableModel{

    ExamenDAO eDAO = new ExamenDAO();

    public ExamenDAO geteDAO() {
        return eDAO;
    }

    public void seteDAO(ExamenDAO eDAO) {
        this.eDAO = eDAO;
    }
    
    
    @Override
    public int getRowCount() {
       return eDAO.contadorExam();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
      switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Categoria";
             case 2:
                return "Laboratorio";
             case 3:
                return "Unidad de Medida";
            default:
                return "--";
           
        }
    }

    
    @Override
    public Object getValueAt(int fila, int columna) {
        Examen ex = (Examen)eDAO.TodosExam().get(fila);
         switch (columna) {
            case 0:
                return ex.getNombre();
            case 1:
                return ex.getCategoria().getNombre_cat();
             case 2:
                return ex.getLaboratorio();
             case 3:
                return  ex.getUnidad_medida();
            default:
                return "--";
           
        }
        
        
    }
    
}
