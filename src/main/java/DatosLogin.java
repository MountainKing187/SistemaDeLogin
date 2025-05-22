import java.io.*;
import java.util.ArrayList;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {
        try (BufferedReader lector = new BufferedReader(new FileReader("login.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(";")){
                    credenciales.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void checkFile() throws IOException {
        File archivo = new File("login.txt");

        if (!archivo.exists()) {
            archivo.createNewFile(); // Crea el archivo si no existe
            System.out.println("Archivo creado.");
        }
    }

    private void createFile() throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter("salida.txt"));

        escritor.write("Primera línea");
        escritor.newLine();
        escritor.write("Segunda línea");
        escritor.flush();
    }
}