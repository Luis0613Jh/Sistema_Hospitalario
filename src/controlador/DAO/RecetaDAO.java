/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ConsultaJpaController;
import controlador.RecetaJpaController;
import modelo.Consulta;
import modelo.Receta;

/**
 *
 * @author CNH
 */
public class RecetaDAO {

    private long idConsulta;
    private RecetaJpaController recetajpa = new RecetaJpaController();
    private ConsultaJpaController jpaconsulta = new ConsultaJpaController();
    private Consulta consulta = new Consulta();
    private Receta receta = new Receta();

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public RecetaJpaController getRecetajpa() {
        return recetajpa;
    }

    public void setRecetajpa(RecetaJpaController recetajpa) {
        this.recetajpa = recetajpa;
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

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    

    public boolean editarReceta(Receta receta) {
        try {
            recetajpa.edit(receta);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public Consulta encontrarConsulta(Long id) {
        try {
            System.out.println("ingresada encontrar");
            return jpaconsulta.findConsulta(idConsulta);
        } catch (Exception e) {
            System.out.println("no ingresada encontrar");
            return null;
        }
    }
        public Receta buscarReceta(long id){
        Receta aux = new Receta();
        try {
            aux = recetajpa.findReceta(id);
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    public void CargarConsulta() {
        this.setConsulta(jpaconsulta.findConsulta(idConsulta));
    }

}
