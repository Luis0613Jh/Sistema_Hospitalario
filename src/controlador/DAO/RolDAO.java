/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;
import controlador.RolJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
/**
 *
 * @author CNH
 */
public class RolDAO {

    private RolJpaController rolJpa = new RolJpaController();

    private Rol rol;

    public boolean agregarRol(Rol rol) {
        try {
            rolJpa.create(rol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Rol buscarRol(Rol rol) {
        Rol aux = new Rol();
        try {
            aux = rolJpa.findRol(rol.getId_rol());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    public Rol buscarRolId(int id) {
        Rol aux = new Rol();
        try {
            aux = rolJpa.findRol(Long.valueOf(id));
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    public void eliminarRol(Rol rol) {
        try {
            rolJpa.destroy(rol.getId_rol());
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public List listarRoles() {
        List<Rol> listaRol = new ArrayList<Rol>();
        try {
            listaRol = rolJpa.findRolEntities();
            return listaRol;
        } catch (Exception e) {
            return listaRol;
        }
    }

    public Rol getRol() {
        if (this.rol == null) {
            this.rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
