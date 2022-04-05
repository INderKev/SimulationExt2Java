package logica;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


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
        //variables que contendrán el di de los bloque e inodos según su posición en el array
	int idInodoActual =asignarBitmapInodos(), idBloque=asignarBitmapBloques(), idBloqueAux = -1;
        int indexPadre = 0;
        BloqueCarpetas bloque;
        //Busca el Inodo del padre para ponerle que tiene un hijo
        if(this.inodos.size()==0){
            indexPadre = 0;
        }else{
            indexPadre = buscarPadre(idPadre);
        }
   
        //Revisa si ocurrio un error al asignar un identificador, no hay más espacio en los mapas de bits
        if(idInodoActual == -1 || idBloque == -1 ||indexPadre ==-1 ){
            System.out.println("No hay más espacio en los mapas de bits o no se encontro el padre");
            return -1;
        }           

        // se pone en el bloque del padre el id del hijo
        if( this.inodos.size()!=0){
            System.out.println("entro set hijo ");
            if(this.inodos.get(indexPadre).setIdHijo(idInodoActual, nombre)==-1){
                
                //es necesario otro apuntador 
                idBloqueAux = asignarBitmapBloques();
                //el apuntador directo está ocupado por lo cual se utilizará un apuntador indirecto
                int resultado = this.inodos.get(indexPadre).setHIjoIndirecto(idBloque, idBloqueAux, idInodoActual, nombre);
                switch(resultado){
                    case -1:
                        // no hay espacio en el apuntador indirecto, se devuelven los ids
                        devolverIdBloque(idBloqueAux);
                        devolverIdBloque(idBloque);
                        return -1;
                    case 0:
                        //se utilizaron todos los id de bloques por lo cual es necesario pedir otro id
                        bloque = new BloqueCarpetas(idBloque, asignarBitmapBloques(), indexPadre);
                        // se añade el inodo a la lista de inodos
                        inodos.add(new Inodo(idInodoActual, tipo, bloque));
                        return 0;
                    case 1:
                        //solo se utilizo un apuntador  idBloque, queda libre idBloqueAux
                        bloque = new BloqueCarpetas(idBloque, idBloqueAux, indexPadre);
                        // se añade el inodo a la lista de inodos
                        inodos.add(new Inodo(idInodoActual, tipo, bloque));
                        return 0;               
                }
            }else{
                
                //se agrego al apuntador directo
                bloque = new BloqueCarpetas(idBloque, idInodoActual, idPadre);
                // se añade el inodo a la lista de inodos
                inodos.add(new Inodo(idInodoActual, tipo, bloque));
                return 0; 
            }
        }else{
            //para el primer inodo
            bloque = new BloqueCarpetas(idBloque, idInodoActual, idInodoActual);
            inodos.add(new Inodo(idInodoActual, tipo, bloque));
            return 0; 
        }
        //ocurrio un problema
        System.out.println("no entro");
        return -1;
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
    
    //pone en el mapa de bits de bloque 0 en los id que no se usaron
    private void devolverIdBloque(int idBloque){
        for(int i = 0; i<this.bitmapBloques.length; i++){
		//revisa el primer espacio vacio de bitmaps
		if(this.bitmapBloques[i]==idBloque){
			this.bitmapBloques[i] = 0;
		}
	}
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
            System.out.print(this.bitmapBloques[i]);
        }
        System.out.println("\nINODOS");
        for (int i = 0; i < this.bitmapInodos.length; i++) {
            System.out.print(this.bitmapInodos[i]);
        }
        for (int i = 0; i < this.inodos.size(); i++) {
            System.out.println("\nInodo id: "+this.inodos.get(i).getId());
            HashMap<String,Integer> aux = this.inodos.get(i).getApuntadorDirecto().getCarpetaId();
            System.out.println("Apuntador directo");
            for (Iterator<String> it = aux.keySet().iterator(); it.hasNext();) {
                String val = it.next();
                System.out.println("llave: "+val + " valor: "+ aux.get(val));
            }
            
            //tiene apuntadores indirectos
            if(this.inodos.get(i).getApuntadorIndirecto1()!=null){
                System.out.println("Apuntador indirecto");
                BloqueApuntadoresIndirectos bloqueIndirecto = this.inodos.get(i).getApuntadorIndirecto1();
                System.out.println("Id bloque: "+ bloqueIndirecto.getId()+"\n");
                if(bloqueIndirecto.getBloqueCarpetas1()!=null){
                    System.out.println("Id bloque" + bloqueIndirecto.getBloqueCarpetas1().getId());
                    HashMap<String,Integer> bloques2 = bloqueIndirecto.getBloqueCarpetas1().getCarpetaId();
                    System.out.println("Apuntador indirecto");
                    for (Iterator<String> it = bloques2.keySet().iterator(); it.hasNext();) {
                        String val = it.next();
                        System.out.println("llave: "+val + " valor: "+ bloques2.get(val));
                    }
                }
            }
        }
    }
 	
    private void borrarInodo(){
	
    }
}
