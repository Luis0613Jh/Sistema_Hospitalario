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
         if (hc == null) {
            hc = new HistorialClinico();
        }
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

    public HistorialClinico encontrarHC(HistorialClinico hc) {
        HistorialClinico aux = new HistorialClinico();

        try {
            aux = hcJPAC.findHistorialClinico(hc.getId_historial_clinico());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    public List TodosHistorialClinico() {
        List<HistorialClinico> Lhc = new ArrayList<HistorialClinico>();
        try {
            Lhc = hcJPAC.findHistorialClinicoEntities();   
            return Lhc;
        } catch (Exception e) {
            return Lhc;
        }
    }

    public boolean IntervaloHC(int j, int i) {

        try {
            hcJPAC.findHistorialClinicoEntities(j, i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean contadorHC() {

        try {
            hcJPAC.getHistorialClinicoCount();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
