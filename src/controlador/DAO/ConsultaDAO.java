/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ConsultaJpaController;
import modelo.Consulta;

/**
 *
 * @author RICARDO
 */
public class ConsultaDAO {
    private ConsultaJpaController ConsultaJpa = new ConsultaJpaController();
    private Consulta consulta; 

    public Consulta getConsulta() {
        if(consulta == null){
            consulta = new Consulta();
        }
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    public boolean agregarConsulta(Consulta consulta){
        try {
            ConsultaJpa.create(consulta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
