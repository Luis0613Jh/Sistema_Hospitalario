
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
            System.out.println("ingresada agregar");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada agregar");
            return  false;
        }
    }

 public boolean editarCat(Categoria cat){
     
        try {
         
            CatJPAC.edit(cat);
            System.out.println("ingresada para editar");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada para editar");
            return  false;
        }
    }
  public boolean eliminarCat(Categoria cat){
     
        try {
            CatJPAC.destroy(cat.getId_categoria());
            System.out.println("ingresada eliminar");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada eliminar");
            return  false;
        }
    }
  
  public Categoria encontrarCat(Categoria cat){
     Categoria aux = new Categoria();
        try {
            aux =CatJPAC.findCategoria(cat.getId_categoria());
            System.out.println("ingresada encontrar");
            return aux;
        } catch (Exception e) {
             System.out.println("no ingresada encontrar");
            return  aux;
        }
    }
  
   public List TodasCat(){
     List<Categoria> Lcat = new ArrayList<Categoria>();
        try {
            Lcat= CatJPAC.findCategoriaEntities();
            System.out.println("ingresada tabla");
            return Lcat;
        } catch (Exception e) {
             System.out.println("no ingresada tabla");
            return  Lcat;
        }
    }
   
     public boolean IntervaloCat(int j, int i){
     
        try {
            CatJPAC.findCategoriaEntities(j, i);
            System.out.println("ingresada");
            return true;
        } catch (Exception e) {
             System.out.println("no ingresada");
            return  false;
        }
    }
  public int contadorCat(){
     int total = 0;
        try {
           total = CatJPAC.getCategoriaCount();
            //System.out.println("ingresada contador");
            return total;
        } catch (Exception e) {
           //  System.out.println("no ingresada contador");
            return  0;
        }
    }
}
