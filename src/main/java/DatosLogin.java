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

    public void checkFile() throws IOException {
        File archivo = new File("login.txt");
        if (!archivo.exists()) {
            throw new IOException("Archivo no existe");
        }
    }

    public void deleteFile(){
        File archivo = new File("login.txt");
        try {
            checkFile();
            archivo.delete();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFile() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("login.txt"))){
            escritor.write("""
                    usuario1;clave123
                    usuario2;abc456
                    nataly;clave123
                    catalina;gato456
                    donnie;perro789
                    kitty;miau321
                    isi;chao987
                    xiao;ola123""");
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}