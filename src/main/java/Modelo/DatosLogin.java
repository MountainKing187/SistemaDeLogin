package Modelo;

import utils.FileManager;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase responsable de cargar las credenciales desde un archivo.
 */
public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final FileManager loginText = new FileManager("login.txt");

    /**
     * Constructor que inicializa las credenciales desde el archivo.
     */
    public DatosLogin() {
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
                usuarios.add(new Usuario(nombre,clave,""));
            }
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}