package Modelo;

import utils.FileManager;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    // public ArrayList<String> credenciales = new ArrayList<>();
    private final FileManager loginText = new FileManager("login.txt");
    private boolean loginExist = loginText.checkFile();

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
        //crearArchivoSiNoExiste();
        manejoDeLoginText(false);
        cargarUsuarios();
    }

    /**
     * Lee el archivo login.txt y agrega las líneas válidas a la lista de usuarios.
     */
    private void cargarUsuarios() {
        ArrayList<String> usuariosText = loginText.cargarLineas();
        String nombre;
        String clave;
        for (String usuario : usuariosText) {
            if (usuario.contains(";")) {
                nombre = usuario.split(";")[0];
                clave = usuario.split(";")[1];
                usuarios.add(new Usuario(nombre,clave));
            }
        }
    }

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

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean getLoginExist(){
        return loginExist;
    }

}