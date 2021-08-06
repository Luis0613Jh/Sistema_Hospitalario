/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.HistorialClinicoJpaController;
import modelo.HistorialClinico;

/**
 *
 * @author Jean Agreda
 */
public class HistorialClinicoDAO {

    private HistorialClinicoJpaController hcJPAC = new HistorialClinicoJpaController();
    private HistorialClinico exam = new HistorialClinico();

    public HistorialClinico getExam() {
        return exam;
    }

    public void setExam(HistorialClinico exam) {
        this.exam = exam;
    }

    public boolean agregarHC(HistorialClinico hc) {

        try {
            hcJPAC.create(hc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
     public boolean editarrHC(HistorialClinico hc) {

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
     
      public boolean encontrarHC(HistorialClinico hc){
     
        try {
            hcJPAC.findHistorialClinico(hc.getId_historial_clinico());
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada");
            return  false;
        }
    }
  public boolean contadorHC(){
     
        try {
            hcJPAC.getHistorialClinicoCount();
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada");
            return  false;
        }
    }

}
