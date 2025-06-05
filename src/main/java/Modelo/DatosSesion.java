package Modelo;

import java.io.*;
import java.util.Scanner;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;

    public DatosSesion(String usuario) {
        this.nombreArchivo = usuario + "_todo.txt";
        crearArchivoSiNoExiste();
    }

    /**
     * Crea el archivo de tareas si no existe.
     */
    private void crearArchivoSiNoExiste() {
        // TODO: Verificar existencia del archivo y crearlo si no existe.
    }

    /**
     * Escribe una nueva tarea al final del archivo.
     *
     * @param tarea Texto de la tarea.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public boolean escribirTarea(String tarea) {
        // TODO: Implementar escritura en el archivo.
        return false;
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void mostrarTareas() {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))){
            System.out.println(lector.readLine());
        }catch (IOException e){
            System.out.println(e);
        }
        // TODO: Leer y mostrar cada línea del archivo.
    }
}