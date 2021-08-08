/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ConsultaJpaController;
import controlador.DiagnosticoJpaController;
import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Persona;

/**
 *
 * @author CNH
 */
public class DiagnosticoDAO {

    private long idConsulta;
    private ConsultaJpaController jpaconsulta = new ConsultaJpaController();
    private DiagnosticoJpaController jpadiagnostico = new DiagnosticoJpaController();
    private Consulta consulta = new Consulta();
    private Diagnostico diagnostico = new Diagnostico();
    private PersonaDAO pesonadao = new PersonaDAO();
    private MedicoDAO medicodao = new MedicoDAO();


    public DiagnosticoJpaController getJpadiagnostico() {
        return jpadiagnostico;
    }

    public void setJpadiagnostico(DiagnosticoJpaController jpadiagnostico) {
        this.jpadiagnostico = jpadiagnostico;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ConsultaJpaController getJpaconsulta() {
        return jpaconsulta;
    }

    public void setJpaconsulta(ConsultaJpaController jpaconsulta) {
        this.jpaconsulta = jpaconsulta;
    }

    public Diagnostico getDiagnostico() {
        if (diagnostico == null) {
            diagnostico = new Diagnostico();
        }
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public PersonaDAO getPesonadao() {
        return pesonadao;
    }

    public void setPesonadao(PersonaDAO pesonadao) {
        this.pesonadao = pesonadao;
    }

    public MedicoDAO getMedicodao() {
        return medicodao;
    }

    public void setMedicodao(MedicoDAO medicodao) {
        this.medicodao = medicodao;
    }
    

    public boolean agregarDiagnostico(Diagnostico diag) {
        try {
            this.jpadiagnostico.create(diag);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void CargarConsulta() {
        this.setConsulta(jpaconsulta.findConsulta(idConsulta));
    }
    
    public Consulta encontrarConsulta (Long id) {
        try {
            return jpaconsulta.findConsulta(idConsulta);
        } catch (Exception e) {
            return null;
        }
    }
    
//        public Persona encontrarPersona(Long id) {
//        try {
//            System.out.println("ingresada encontrar");
//            return jpaconsulta.findConsulta(idConsulta);
//        } catch (Exception e) {
//            System.out.println("no ingresada encontrar");
//            return null;
//        }
//    }

}
