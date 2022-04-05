
package logica;


public class Inodo {
    private String nombre;
    private int id;
    private int tamano ;//KB
    private int tipo ;// 1 carpeta
    //private String propietario;
    //private String permisos;
    private String fechaCreacion;
    //apuntadores directos
    private Bloque apuntadorDirecto;
    //Apuntadores Indirectos
    private Bloque apuntadorIndirecto1;
    private Bloque apuntadorIndirecto2;
    private Bloque apuntadorIndirecto3;

    
    public Inodo(String nombre, int id, int tipo, String fecha, Bloque bloque){
        this.id = id;
	this.tamano = 128;
	this.tipo = tipo;
	this.fechaCreacion= fecha;
	//this.permisos = permisos;
    //this.propietario = propietario;
	this.apuntadorDirecto = bloque;
    }
    
    //administra los apuntadores del inodo
    public void settearBloque(Bloque bloque){
        this.apuntadorIndirecto1 = bloque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


    public int setIdHijo(int idHijo){   
        //revisa si ya está utilizado el primer apuntador (directo)
        if(apuntadorDirecto.getIdHijo()==-1){
            apuntadorDirecto.setIdHijo(idHijo);
            return 0;
        }else{
            apuntadorIndirecto1
        }
    }
    
}
