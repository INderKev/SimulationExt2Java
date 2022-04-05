
package logica;

import java.util.ArrayList;


public class Inodo {
    private int id;
    private int tamano ;//KB
    private int tipo ;// 1 carpeta
    //private String propietario;
    //private String permisos;
    private String fechaCreacion;
    //apuntadores directos
    private BloqueCarpetas apuntadorDirecto;
    //Apuntadores Indirectos solo pueden haber dos por cada uno
    private BloqueApuntadoresIndirectos apuntadorIndirecto1;
    //private ArrayList<Bloque> apuntadorIndirecto2;
   

    
    public Inodo( int id, int tipo, String fecha, BloqueCarpetas bloque){
        this.id = id;
        this.tamano = 128;
        this.tipo = tipo;
        this.fechaCreacion= fecha;
        //this.permisos = permisos;
        //this.propietario = propietario;
        this.apuntadorDirecto = bloque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int setIdHijo(int idHijo, String nombre){   
        //revisa si ya está utilizado el primer apuntador (directo)
        if(apuntadorDirecto.getId("hijo")==-1){
            apuntadorDirecto.setHijo(nombre, idHijo);
            return 0;
        } 
        // Habrá que revisar los apuntadores indirectos por lo cual es necesario tener 2 ids
        return -1;
    }
    
    public int setHIjoIndirecto(int idBloque1, int idBloque2, String nombre, int idInodo){
        // se revisa si ya existen apuntadores indirectos existentes
        if(this.apuntadorIndirecto1==null){
             apuntadorIndirecto1 = new BloqueApuntadoresIndirectos(idBloque1, idBloque2, nombre, idInodo);
             return 0;
        }
        //ya está creado el apuntador indirecto
        //revisa si el bloque de apuntadores está vacio
        if(this.apuntadorIndirecto1.getBloqueCarpetas1()==null){
            this.apuntadorIndirecto1.setBloqueCarpeta1(new BloqueCarpetas(idBloque1, nombre, idBloque2));
            //cantidad de bloques nuevos
            return 0;
        }
        //revisa si queda espacio en el bloque de carpetas
        if(this.apuntadorIndirecto1.getBloqueCarpetas1().cantidadApuntadores()<3){
            this.apuntadorIndirecto1.getBloqueCarpetas1().setHijo(nombre, idBloque1);
            return 1;
        }     
        //revisa si el bloque de apuntadores directo tiene la segunda carpeta vacía para crearlo
        if(this.apuntadorIndirecto1.getBloqueCarpetas2()==null){
            this.apuntadorIndirecto1.setBloqueCarpeta2(new BloqueCarpetas(idBloque1, nombre, idBloque2));
            //cantidad de bloques nuevos
            return 0;
        }
        //revisa si queda espacio en el bloque de apuntadores 
        if(this.apuntadorIndirecto1.getBloqueCarpetas2().cantidadApuntadores()<3){
            this.apuntadorIndirecto1.getBloqueCarpetas2().setHijo(nombre, idBloque1);
            return 1;
        }
        //no queda espacio en el apuntador 
        return -1;
    }

}
