/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabla;

import controlador.PersonaJpaController;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Persona;

/**
 *
 * @author CNH
 */
public class modeloCitas extends AbstractTableModel {

    private List<Consulta> listaCitas;
    private PersonaJpaController jpaconsulta = new PersonaJpaController();

    public List<Consulta> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Consulta> listaCitas) {
        this.listaCitas = listaCitas;
    }

    @Override
    public int getRowCount() {
        return listaCitas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "Fecha";
            case 2:
                return "Hora";
            case 3:
                return "Paciente";
            default:
                return "--";
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Consulta consulta = listaCitas.get(fila);
        switch (columna) {
            case 0:
                return consulta.getId_consulta().toString();
            case 1:
                return consulta.getFecha_cita();
            case 2:
                return consulta.getHora_cita();
            case 3:
                Persona per = jpaconsulta.findPersona(consulta.getId_paciente());
                return per.getNombre() + " " + per.getApellido();
            default:
                return "--";
        }
    }
}
