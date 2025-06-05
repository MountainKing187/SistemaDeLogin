package Modelo;

import utils.FileManager;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();
    public final FileManager loginText = new FileManager(
            "login.txt",
            """
                 usuario1;clave123
                 usuario2;abc456
                 nataly;clave123
                 catalina;gato456
                 donnie;perro789
                 kitty;miau321
                 isi;chao987
                 xiao;ola123
                 admin;admin1""");
    public boolean loginExist = loginText.checkFile();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        //crearArchivoSiNoExiste();
        manejoDeLoginText(false);
        cargarUsuarios();
    }

    /**
     * Devuelve la lista de credenciales cargadas.
     */
    public ArrayList<String> getCredenciales() {
        return credenciales;
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de credenciales.
     */
    private void cargarUsuarios() {

        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/login.txt"))) {
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
    /*
    public boolean checkFile(){
        File archivo = new File("src/main/login.txt");
        return archivo.exists();
    }

    public void deleteFile(){
        File archivo = new File("src/main/login.txt");
        if (checkFile()){
            archivo.delete();
        }
    }

    public void createFile() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/login.txt"))){
            escritor.write("""
                    usuario1;clave123
                    usuario2;abc456
                    nataly;clave123
                    catalina;gato456
                    donnie;perro789
                    kitty;miau321
                    isi;chao987
                    xiao;ola123
                    admin;admin1""");
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    private void crearArchivoSiNoExiste() {
        if (!checkFile()) createFile();
    }
    */
    public void manejoDeLoginText(boolean deleteLogin){
        if(!loginExist) {
            loginText.createFile();
            System.out.println("Archivo login creado.");
        }
        else if (loginExist && deleteLogin) {
            loginText.deleteFile();
            System.out.println("Archivo login eliminado.");
        }
        loginExist = loginText.checkFile();

    }
}