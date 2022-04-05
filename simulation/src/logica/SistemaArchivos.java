package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import logica.Bloque;
import logica.Inodo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SistemaArchivos {
    //cantidad de Inodos y bloques que se pueden crear
    private int bitmapInodos[];
    private int bitmapBloques[];
    private ArrayList<Inodo> inodos;
    //private String usuario;

    public SistemaArchivos(){
        this.bitmapInodos = new int [100];
	this.bitmapBloques = new int [100];
        this.inodos = new ArrayList<Inodo>();
    }
    
    //public void crearInodo(String nombre, int idPadre, String permisos){
    public int crearInodo(int tipo, String nombre, int idPadre){ 
        
	int idNodo =asignarBitmapInodos(), idBloque=asignarBitmapBloques();
        int indexPadre = 0;
        //Busca el bloque del padre para ponerle que tiene un hijo
        if(idPadre != 0){
            indexPadre = buscarPadre(idPadre);
        }
        
        //Revisa si ocurrio un error al asignar un identificador, no hay más espacio en los mapas de bits
        if(idNodo == -1 || idBloque == -1 || indexPadre == -1){
            System.out.println("No hay más espacio en los mapas de bits o no se encontro el id del padre");
            return -1;
        }       
        // se crea el bloque que contendra el id del padre y el actual
        Bloque bloque = new Bloque(idPadre, idBloque);
        // se añade el inodo a la lista de inodos
	inodos.add(new Inodo(nombre ,idNodo, 1, obtenerFechaYHoraActual(), bloque ));
        // se pone en el bloque del padre el id del hijo
        this.inodos.get(indexPadre).getApuntadorDirecto().setIdHijo(idNodo);
       
        return 0;
    }

    private String obtenerFechaYHoraActual(){
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);
        return strDate;
    }
    
    private int buscarPadre(int idPadre){
        for (int i = 0; i < this.inodos.size(); i++) {
            if(this.inodos.get(i).getId()==idPadre){
                return i;
            }
        }
        return -1;
    }
    
    private int asignarBitmapBloques(){
    	//asiga el valor de ocupado en el bitmap de bloques
	for(int i = 0; i<this.bitmapBloques.length; i++){
		//revisa el primer espacio vacio de bitmaps
		if(this.bitmapBloques[i]==0){
			this.bitmapBloques[i] = 1;
			return i;
		}
	}
        return -1;
    }
    
    private int asignarBitmapInodos(){
        //asigna el valor de ocupado en el bitmap de inodos
    	for(int i = 0; i<this.bitmapInodos.length; i++){
		//revisa el primer espacio vacio de bitmaps
		if(this.bitmapInodos[i]==0){
			this.bitmapInodos[i] = 1;
			return i;
			
		}
	}
        return -1;
    }
     
    public void imprimirDatos(){
        System.out.println("BLOQUES");
        for (int i = 0; i < this.bitmapBloques.length; i++) {
            System.out.println(this.bitmapBloques[i]);
        }
        System.out.println("INODOS");
        for (int i = 0; i < this.bitmapInodos.length; i++) {
            System.out.println(this.bitmapInodos[i]);
        }
        for (int i = 0; i < this.inodos.size(); i++) {
            System.out.println(this.inodos.get(i));
        }
    }
 	
    private void borrarInodo(){
	
    }
}
