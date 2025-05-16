package libProceso;

/**
 *  Clase que representa las funciones de la biblioteca dinamica JNI
 */
public class JavaProceso {

    public native String algoritmo_SJF_no_expulsivo(String json);
    public native String algoritmo_SJF_expulsivo(String json);

    public JavaProceso() {
        try {
            System.loadLibrary("sjf");
            System.out.println("Biblioteca cargada exitosamente!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }
}
