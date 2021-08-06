/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabla;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Examen;

public class modeloExam extends AbstractTableModel{

    private List<Examen> listaExamenes;

    public List<Examen> getListaExamenes() {
        return listaExamenes;
    }

    public void setListaExamenes(List<Examen> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }

    @Override
    public int getRowCount() {
       return listaExamenes.size();
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
        Examen examen = listaExamenes.get(fila);
         switch (columna) {
            case 0:
                return examen.getNombre();
            case 1:
                return examen.getCategoria().getNombre_cat();
             case 2:
                return examen.getListaLab();
             case 3:
                return  examen.getUnidad_medida();
            default:
                return "--";
        }
    }
    
}
