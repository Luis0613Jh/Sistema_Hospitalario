package controlador.DAO;

import controlador.ExamenJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Examen;

public class ExamenDAO {

    private ExamenJpaController examJPAC = new ExamenJpaController();
    private Examen exam = new Examen();

    public Examen getExam() {
        if (exam == null) {
            exam = new Examen();
        }
        return exam;
    }

    public void setExam(Examen exam) {
        this.exam = exam;
    }

    /**
     * Metodo que crea un nuevo examen en la base de datos
     *
     * @param exam
     * @return
     */
    public boolean agregarExam(Examen exam) {
        try {
            examJPAC.create(exam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que edita un examen en la base de datos
     *
     * @param exam
     * @return
     */
    public boolean editarExam(Examen exam) {

        try {
            examJPAC.edit(exam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que elimina un examen en la base de datos
     * @param exam
     * @return
     */
    public boolean eliminarExam(Examen exam) {

        try {
            examJPAC.destroy(exam.getId_examen());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que encuentra un examen existente en la base de datos
     * @param exam
     * @return
     */
    public Examen encontrarExam(Examen exam) {
        Examen aux = new Examen();
        try {
            aux = examJPAC.findExamen(exam.getId_examen());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    /**
     * Metodo que lista todos los examenes de la base de datos
     * @return
     */
    public List TodosExam() {
        List<Examen> Ecat = new ArrayList<>();
        try {
            Ecat = examJPAC.findExamenEntities();
            return Ecat;
        } catch (Exception e) {
            return Ecat;
        }
    }

    /**
     * Metodo que lista todos los examenes de la base de datos, mediante un
     * intervalo.
     * @param j
     * @param i
     * @return
     */
    public boolean IntervaloExam(int j, int i) {

        try {
            examJPAC.findExamenEntities(j, i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo que cuenta los examenes existentes en la base de datos
     * @return
     */
    public int contadorExam() {
        int total = 0;
        try {
            total = examJPAC.getExamenCount();
            return total;
        } catch (Exception e) {
            return 0;
        }
    }
}
