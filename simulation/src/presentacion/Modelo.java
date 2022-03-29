
package presentacion;

public class Modelo {
    
    //manejador de la logica 
    //private SistemaTriangular miSistema;
    private Vista ventana;
    

    public Modelo() {        
        getVentana().reset(true);
    }
    
    // Métododos generados para ocultación de información
    
    public Vista getVentana(){        
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;                
    }

    
    /*genera solo una instancia del sistema manejador
    public SistemaTriangular getMiSistema() {
        if(miSistema == null){
            miSistema = new SistemaTriangular();
        }
        return miSistema;                
    }*/
    
    // Funcionalidades halladas en los requirimientos (casos de uso)
    
    public void iniciar(){
        getVentana().setSize(800, 800);
        getVentana().setVisible(true);
        
   
    }   

         
}
