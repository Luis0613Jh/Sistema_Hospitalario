package controlador.DAO;

import controlador.ConsultaJpaController;
import modelo.Consulta;

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
