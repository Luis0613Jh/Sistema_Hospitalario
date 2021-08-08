/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ExamenJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Examen;

/**
 *
 * @author Jean Agreda
 */
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

    public boolean agregarExam(Examen exam) {
        try {
            examJPAC.create(exam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarExam(Examen exam) {

        try {
            examJPAC.edit(exam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarExam(Examen exam) {

        try {
            examJPAC.destroy(exam.getId_examen());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Examen encontrarExam(Examen exam) {
        Examen aux = new Examen();
        try {
            aux = examJPAC.findExamen(exam.getId_examen());
            System.out.println("ingresada");
            return aux;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return aux;
        }
    }

    public List TodosExam() {
        List<Examen> Ecat = new ArrayList<Examen>();
        try {
            Ecat = examJPAC.findExamenEntities();
            System.out.println("ingresada tabla");
            return Ecat;
        } catch (Exception e) {
            System.out.println("no ingresada tabla");
            return Ecat;
        }
    }

    public boolean IntervaloExam(int j, int i) {

        try {
            examJPAC.findExamenEntities(j, i);
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return false;
        }
    }

    public int contadorExam() {
        int total = 0;
        try {
            total = examJPAC.getExamenCount();
            System.out.println("ingresada");
            return total;
        } catch (Exception e) {
            System.out.println("no ingresada");
            return 0;
        }
    }
}
