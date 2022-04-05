
package logica;
import java.util.HashMap; 

public class BloqueCarpetas extends Bloque{
    private HashMap<String,Integer> carpetaId ;
    
    public BloqueCarpetas(int id, int idPadre, String nombre, String nombrePadre) {
        super(id);
        this.carpetaId = new HashMap<String,Integer>();
        this.carpetaId.put(nombrePadre, idPadre);
        this.carpetaId.put(nombre, id);
        this.carpetaId.put("hijo", -1);
    }

    public BloqueCarpetas(int idBloqueCarpeta, String nombre, int idInodo){
        super(idBloqueCarpeta);
        this.carpetaId = new HashMap<String,Integer>();
        this.carpetaId.put(nombre, idInodo);
    }

    public int getId (String nombre){
        return this.carpetaId.get(nombre);
    }

    public void setHijo(String nombre, int idHijo){
        this.carpetaId.remove("hijo");
        this.carpetaId.put(nombre, idHijo);

    }
    
    public void quitarHijo(String nombre){
        this.carpetaId.remove(nombre);
    }
   
    public int cantidadApuntadores(){
        return this.carpetaId.size();
    }
}
