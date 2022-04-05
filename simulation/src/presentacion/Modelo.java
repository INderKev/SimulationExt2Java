
package presentacion;

import logica.SistemaArchivos;

public class Modelo {
    
    //manejador de la logica 
    //private SistemaTriangular miSistema;
    private Vista ventana;
    private SistemaArchivos miSistema;

    
    public Modelo() {      
        getMiSistema();
        //getVentana().reset(true);
    }
    
    // Métododos generados para ocultación de información
    
    public Vista getVentana(){        
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;                
    }

    
    //genera solo una instancia del sistema manejador
    public SistemaArchivos getMiSistema() {
        if(miSistema == null){
            miSistema = new SistemaArchivos();
        }
        return miSistema;                
    }
    
    // Funcionalidades halladas en los requirimientos (casos de uso)
    /*
    public void iniciar(){
        getVentana().setSize(800, 800);
        getVentana().setVisible(true);
    }   
    */
    // Crear un inodo
    public void crearInodo(int tipo, String nombre, int padre){
        if(this.miSistema.crearInodo(tipo, nombre, padre)==-1){
            System.out.println("Error manejar al crear el inodo");
        }
    }
    
    public void imprimir(){
        miSistema.imprimirDatos();
    }
    
    public void eliminarNodo(){
    
    }
         
}
