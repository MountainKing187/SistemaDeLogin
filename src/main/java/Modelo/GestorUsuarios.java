package Modelo;

import utils.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private final String archivo = "login.txt";
    private final FileManager loginText;

    public GestorUsuarios() {
        loginText = new FileManager(archivo);
    }

    public void registrar(String usuario, String clave) {
        loginText.añadirLinea(usuario+";"+clave);
    }
}