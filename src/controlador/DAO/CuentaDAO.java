package controlador.DAO;

import controlador.CuentaJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Cuenta;

public class CuentaDAO {
    private CuentaJpaController cuentaJpa = new CuentaJpaController();
    private Cuenta cuenta;

    public Cuenta getCuenta() {
        if(this.cuenta == null){
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public boolean agregarCuenta(Cuenta cuenta){
        try {
            cuentaJpa.create(cuenta);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    public Cuenta buscarCuenta(Cuenta cuenta){
        Cuenta aux = new Cuenta();
        try {
            aux = cuentaJpa.findCuenta(cuenta.getId_cuenta());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
    public List listarCuentas(){
        List<Cuenta> listaCuenta = new ArrayList<Cuenta>();
        try {
            listaCuenta = cuentaJpa.findCuentaEntities();
            return listaCuenta;
        } catch (Exception e) {
            return listaCuenta;
        }
    }
}