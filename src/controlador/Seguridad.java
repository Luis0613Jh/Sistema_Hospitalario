/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.lang.String.valueOf;

/**
 *
 * @author ricar
 */
public class Seguridad {
    /**
    * Este metodo se usa para Encriptar la clave del usuario.
    * @param clave Con este parametro recibimos la clave que deseamos encriptar.
    * @return String Retorna una cadena donde se encuentre la clave encriptada.
    */
    public String Encriptar (String clave){
        var array=clave.toCharArray();
        for(var i=0;i<array.length;i++){
            array[i]=(char)(array[i]+(char)((7*i)+(3*(i+1))));
        }
        var encriptado=valueOf(array);
        return encriptado;
    }
    
    /**
    * Este metodo se usa para Desencriptar la clave del usuario.
    * @param clave Con este parametro recibimos la clave que deseamos desencriptar.
    * @return String Retorna una cadena donde se encuentre la clave desencriptada.
    */
    public String Desencriptar (String clave){
        var array=clave.toCharArray();
        for(var i=0;i<array.length;i++){
            array[i]=(char)(array[i]-(char)((7*i)+(3*(i+1))));
        }
        var desencriptado=valueOf(array);
        return desencriptado;
    }
}
