
import presentacion.Modelo;

public class Launcher {

    private Modelo miApp;

    public static void main(String[] args) {
        new Launcher();
    }

    public Launcher() {
        miApp = new Modelo();
        //miApp.iniciar();
        // carpeta = 1, nombre, padre
        miApp.crearInodo(1,"/", 0);
        miApp.imprimir();
        miApp.crearInodo(1,"var", 0);
        miApp.imprimir();

        
    }
    
}
