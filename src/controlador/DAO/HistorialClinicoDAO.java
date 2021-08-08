/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.HistorialClinicoJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialClinico;

/**
 *
 * @author Jean Agreda
 */
public class HistorialClinicoDAO {

    private HistorialClinicoJpaController hcJPAC = new HistorialClinicoJpaController();
    private HistorialClinico hc = new HistorialClinico();

    public HistorialClinico getHc() {
        return hc;
    }

    public void setHc(HistorialClinico exam) {
        this.hc = exam;
    }

    public boolean agregarHC(HistorialClinico hc) {

        try {
            hcJPAC.create(hc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarHC(HistorialClinico hc) {

        try {
            hcJPAC.edit(hc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//      public boolean eliminarHC(HistorialClinico hc) {
//
//        try {
//            hcJPAC.edit(hc);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
    public HistorialClinico encontrarHC(HistorialClinico hc) {
        HistorialClinico aux = new HistorialClinico();

        try {
            aux = hcJPAC.findHistorialClinico(hc.getId_historial_clinico());
            System.out.println("ingresada");
            return aux;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return aux;
        }
    }

    public List TodasCat() {
        List<HistorialClinico> Lhc = new ArrayList<HistorialClinico>();
        try {
            Lhc = hcJPAC.findHistorialClinicoEntities();
            System.out.println("ingresada tabla");
            return Lhc;
        } catch (Exception e) {
            System.out.println("no ingresada tabla");
            return Lhc;
        }
    }

    public boolean IntervaloCat(int j, int i) {

        try {
            hcJPAC.findHistorialClinicoEntities(j, i);
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return false;
        }
    }

    public boolean contadorHC() {

        try {
            hcJPAC.getHistorialClinicoCount();
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return false;
        }
    }

}
