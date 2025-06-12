package Modelo;

import java.io.*;
import utils.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;
    private ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
    private FileManager tareaText;

    public DatosSesion(String usuario) {
        this.nombreArchivo = usuario + "_todo.txt";
        tareaText = new FileManager(nombreArchivo);
        cargarTareas();
    }

    public void cargarTareas(){
        for (String tarea : tareaText.cargarLineas()) listaTareas.add(new Tarea(tarea));
    }

    /**
     * Escribe una nueva tarea al final del archivo.
     *
     * @param tarea Texto de la tarea.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public void escribirTarea(String tarea) {
        tareaText.añadirLinea(tarea);
        cargarTareas();
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void mostrarTareas() {
        for (Tarea tarea: listaTareas){
            System.out.println(tarea.getDescripcion());
        }
    }
}