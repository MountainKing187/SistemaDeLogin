package Controlador;

import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final String usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final String[] Opciones = {"Escribir tareas","Registrar usuarios","Cerrar Sesion"};

    public SesionActiva(String usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        int opcion ;
        do{
            mostrarOpcion();
            opcion = obtenerOpcion();
            if ((opcion == 3 && usuario.equals("admin") || opcion == 2 )){
                break;
            } else if (usuario.equals("admin")) {
                ejecutarOpcionAdmin(opcion);
            } else {
                ejecutarOpcionUsuario(opcion);
            }
        }while (true);
    }

    public void mostrarOpcion(){
        System.out.println("===================");
        System.out.println("Tareas");
        System.out.println("===================");
        if (usuario.equals("admin")){
            System.out.println("1) Escribir tareas");
            System.out.println("2) Registrar usuarios");
            System.out.println("3) Cerrar Sesion");
        } else {
            System.out.println("1) Escribir tareas");
            System.out.println("2) Cerrar Sesion");
        }
    }

    public int obtenerOpcion() {
        int opcion;

        System.out.println("Elija su opcion:");
        String scannerString = scanner.next();
        try {
            opcion = Integer.parseInt(scannerString);
        } catch (NumberFormatException nfe){
            opcion = 0;
            System.out.println("Ingreso un monto no valido");
        }
        return opcion;
    }

    private void ejecutarOpcionUsuario(int opcion) {
        switch (opcion){
            case 1 -> escribirTarea();
            case 2 -> System.out.println("Adios");
            default -> System.out.println("problema");
        }
    }

    private void ejecutarOpcionAdmin(int opcion) {
        switch (opcion){
            case 1 -> escribirTarea();
            case 2 -> registrarUsuario();
            case 3 -> System.out.println("Adios");
            default -> System.out.println("problema");
        }
    }

    private void escribirTarea() {
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void registrarUsuario() {
        // TODO: Usar GestorUsuarios para registrar un nuevo usuario.
    }
}