
package logica;

public class Bloque {
    private int idPadre;
    private int idActual;
    private int idHijo;
    
    // Son los ids respecto a los INODOS
    public Bloque(int idpadre, int id){
        this.idPadre = idpadre;
	this.idActual = id;
	//se crea sin un inodo hijo, por lo que lo tiene en -1
	this.idHijo = -1;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public int getIdActual() {
        return idActual;
    }

    public void setIdActual(int idActual) {
        this.idActual = idActual;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }
    
    
}
