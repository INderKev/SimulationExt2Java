
package logica;

public  class Bloque {

    private int id;

    
    // Son los ids respecto a los INODOS
    public Bloque(int id){
	    this.id = id;
	    //se crea sin un inodo hijo, por lo que lo tiene en -1
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
