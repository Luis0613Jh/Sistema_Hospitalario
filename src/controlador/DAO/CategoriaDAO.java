package controlador.DAO;

import controlador.CategoriaJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDAO {
    private CategoriaJpaController CatJPAC= new CategoriaJpaController();
    private Categoria cat = new Categoria();

    public Categoria getCat() {
        if (cat == null) {
            cat = new Categoria();
        }
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    public boolean agregarCat(Categoria cat){
     
        try {
            CatJPAC.create(cat);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

 public boolean editarCat(Categoria cat){
     
        try {
            CatJPAC.edit(cat);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
  public boolean eliminarCat(Categoria cat){
     
        try {
            CatJPAC.destroy(cat.getId_categoria());
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
  
  public Categoria encontrarCat(Categoria cat){
     Categoria aux = new Categoria();
        try {
            aux =CatJPAC.findCategoria(cat.getId_categoria());
            return aux;
        } catch (Exception e) {
            return  aux;
        }
    }
  
   public List TodasCat(){
     List<Categoria> Lcat = new ArrayList<Categoria>();
        try {
            Lcat= CatJPAC.findCategoriaEntities();
            return Lcat;
        } catch (Exception e) {
            return  Lcat;
        }
    }
   
     public boolean IntervaloCat(int j, int i){
     
        try {
            CatJPAC.findCategoriaEntities(j, i);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
  public int contadorCat(){
     int total = 0;
        try {
           total = CatJPAC.getCategoriaCount();
            return total;
        } catch (Exception e) {
            return  0;
        }
    }
}
