
package logica;
import java.util.HashMap; 
import java.util.Iterator;

public class BloqueCarpetas extends Bloque{
    private HashMap<String,Integer> carpetaId ;
    private String nombre; 
    public BloqueCarpetas(int idBloque, int idInodoActual, int idInodoPadre) {
        super(idBloque);
        this.carpetaId = new HashMap<String,Integer>();
        // "." Inodo actual
        this.carpetaId.put(".", idInodoActual);
        //".." Inodo Padre
        this.carpetaId.put("..", idInodoPadre);   
        this.carpetaId.put("hijo", -1);
    }

    public BloqueCarpetas(int idBloqueCarpeta, String nombre, int idInodo){
        super(idBloqueCarpeta);
        this.nombre = nombre;
        this.carpetaId = new HashMap<String,Integer>();
        this.carpetaId.put(nombre, idInodo);
    }

    public int getId (String nombre){
        for (Iterator<String> it = this.carpetaId.keySet().iterator(); it.hasNext();) {
            String val = it.next();
            if(this.carpetaId.get(val)==-1){
                return -1;
            }
        }
        return 0;
    }

    public HashMap<String, Integer> getCarpetaId() {
        return carpetaId;
    }

    public String getNombre() {
        return nombre;
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
