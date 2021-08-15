package controlador.DAO;

import controlador.HistorialClinicoJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialClinico;

public class HistorialClinicoDAO {

    private HistorialClinicoJpaController hcJPAC = new HistorialClinicoJpaController();
    private PersonaDAO personaDAO = new PersonaDAO();
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

    /**
     * Metodo para crear un nuevo historial clínico en la base de datos
     *
     * @param hc
     * @return
     */
    public boolean agregarHC(HistorialClinico hc) {

        try {
            hcJPAC.create(hc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para editar un historial clínico en la base de datos
     *
     * @param hc
     * @return
     */
    public boolean editarHC(HistorialClinico hc) {

        try {
            hcJPAC.edit(hc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para encontrar un historial clínico en la base de datos mediante
     * su id
     *
     * @param hc
     * @return
     */
    public HistorialClinico encontrarHC(HistorialClinico hc) {
        HistorialClinico aux = new HistorialClinico();

        try {
            aux = hcJPAC.findHistorialClinico(hc.getId_historial_clinico());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    /**
     * Metodo para devolver una lista de historiales clínicos de la base de
     * datos
     *
     * @return
     */
    public List TodosHistorialClinico() {
        List<HistorialClinico> Lhc = new ArrayList<HistorialClinico>();
        try {
            Lhc = hcJPAC.findHistorialClinicoEntities();
            return Lhc;
        } catch (Exception e) {
            return Lhc;
        }
    }

    /**
     * Metodo para devolver una lista de historiales clínicos de la base de
     * datos , mediante un intervalo
     *
     * @param j
     * @param i
     * @return
     */
    public boolean IntervaloHC(int j, int i) {

        try {
            hcJPAC.findHistorialClinicoEntities(j, i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que cuenta los historiales clínicos existentes en la Base de Datos
     *
     * @return
     */
    public boolean contadorHC() {

        try {
            hcJPAC.getHistorialClinicoCount();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public HistorialClinico buscarHistorial(String cedula) {
        for (Object p : TodosHistorialClinico()) {
            if (personaDAO.buscarPersona(((HistorialClinico) p).getPersona()).getCedula().equals(cedula)) {
                System.out.println("SI ENCONTRO HISTORIAL");
                return (HistorialClinico) p;
            }
        }
        return null;
    }

}
