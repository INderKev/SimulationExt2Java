
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
    private ArrayList<BloqueApuntadoresIndirectos> apuntadorIndirecto1;
    private ArrayList<Bloque> apuntadorIndirecto2;
   

    
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

        // revisar que pasa cuando se necesitan otros id o más de los que exiten
    public int setIdHijo(int idHijo, String nombre){   
        //revisa si ya está utilizado el primer apuntador (directo)
        if(apuntadorDirecto.getId("hijo")==-1){
            apuntadorDirecto.setHijo(nombre, idHijo);
            return 0;
        } 
        // se revisa si ya existen apuntadores existentes
        if(this.apuntadorIndirecto1.size()==1){
            //revisa si el primer apuntador indirecto está vacio
            if(this.apuntadorIndirecto1.get(1).getBloqueCarpetas1()==null){
                this.apuntadorIndirecto1.get(1).setBloqueCarpeta1(new BloqueCarpetas(idHijo, nombre, idHijo+1));
                //cantidad de bloques nuevos
                return 1;
            }    
        }
        // revisa si ya existen apuntadores que esten libres
        if(this.apuntadorIndirecto1.size()==2){
            if(this.apuntadorIndirecto1.get(1).getBloqueCarpetas1()==null){
                this.apuntadorIndirecto1.get(1).setBloqueCarpeta1(new BloqueCarpetas(idHijo, nombre, idHijo+1));
                //cantidad de bloques nuevos
                return 1;
            }    
            //revisa si el segundo apuntador indirecto está vacio
            if(this.apuntadorIndirecto1.get(2).getBloqueCarpetas1()==null){
                this.apuntadorIndirecto1.get(2).setBloqueCarpeta1(new BloqueCarpetas(idHijo, nombre, idHijo+1));
                //cantidad de bloques nuevos
                return 1;
            }
        }

        //Revisa cuantos apuntadores están en la sección de indirectos (máx 2)
        if(this.apuntadorIndirecto1.size()<2){
            //crea un Bloque de apuntadores indirectos
            BloqueApuntadoresIndirectos bloqueIndi = new BloqueApuntadoresIndirectos(idHijo);
            //le añade al bloque anterior el bloque de carpetas que se quería crear            
            bloqueIndi.setBloqueCarpeta1(new BloqueCarpetas(idHijo+1, idHijo, nombre));
            //Añade el bloque de apuntadores a la lista del inodo
            this.apuntadorIndirecto1.add(bloqueIndi);
            //cantiad de bloque utilizados
            return 2;
        }

        //Revisa si exite algún 
        if(this.apuntadorIndirecto2.size()<1){

        }

    }
    
}
