package Vista;

import Modelo.DatosLogin;
import Controlador.Login;
import Controlador.SesionActiva;
import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        int opcion ;
        do{
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        }while (opcion != 2);
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        System.out.println("\n====================\n");
        System.out.println("  Sistema de login");
        System.out.println("\n====================\n");
        System.out.println("1) Iniciar sesion");
        System.out.println("2) Salir");
        System.out.println("\n====================\n");
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(int opcion) {
        switch (opcion){
            case 1 -> manejarLogin();
            case 2 -> System.out.println("Adios");
            default -> System.out.println("problema");
        }
    }

    private int obtenerOpcion() {
        String scannerString;
        int opcion;

        System.out.println("Elija su opcion:");
        scannerString = scanner.next();
        try {
            opcion = Integer.parseInt(scannerString);
        } catch (NumberFormatException nfe){
            opcion = 0;
            System.out.println("Ingreso un monto no valido");
        }
        return opcion;
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        String[] usuarioDatos = manejarUsuario();

        if (login.autenticar(usuarioDatos[0],usuarioDatos[1],datos) != null){
            SesionActiva sesion = new SesionActiva(usuarioDatos[0]);
        } else {
            System.out.println("Este usuario no existe.");
        }
    }

    private String[] manejarUsuario(){
        System.out.println("Escriba su usuario: ");
        String nombre = scanner.next();
        System.out.println("Escriba su contraseña: ");
        String contrasena = scanner.next();

        return new String[]{nombre, contrasena};
    }
}