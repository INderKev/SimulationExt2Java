
package logica;


public class BloqueApuntadoresIndirectos extends Bloque{
    private BloqueCarpetas bloque1;
    private BloqueCarpetas bloque2; 
    
    public BloqueApuntadoresIndirectos(int idBloqueIndirecto, int idBloqueCarpetas, String nombre, int idInodo){
        super(idBloqueIndirecto);
        this.bloque1= new BloqueCarpetas(idBloqueCarpetas, nombre, idInodo);
    }
    public BloqueCarpetas getBloqueCarpetas1(){
        return this.bloque1;
    }

    public BloqueCarpetas getBloqueCarpetas2(){
        return this.bloque2;
    }

    public void setBloqueCarpeta1(BloqueCarpetas bloque){
        this.bloque1 = bloque;
    }

    public void setBloqueCarpeta2(BloqueCarpetas bloque){
        this.bloque2 = bloque;
    }
    
    public void removeBloqueCarpeta1(){
        this.bloque1 = null;
    }
   
    public void removeBloqueCarpeta2(){
        this.bloque2 = null;
    }
}
