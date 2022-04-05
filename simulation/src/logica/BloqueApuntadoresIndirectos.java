
package logica;


public class BloqueApuntadoresIndirectos extends Bloque{
    private BloqueCarpetas bloque1;
    private BloqueCarpetas bloque2; 
    
    public BloqueApuntadoresIndirectos(int id ){
        super(id);
    }
    
    public Bloque getBloqueCarpetas1(){
        return this.bloque1;
    }

    public Bloque getBloqueCarpetas2(){
        return this.bloque2;
    }

    public void setBloqueCarpeta1(BloqueCarpetas bloque){
        this.bloque1 = bloque;
    }

    public void setBloqueCarpeta2(BloqueCarpetas bloque){
        this.bloque2 = bloque;
    }
}
