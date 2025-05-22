import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        manejarLogin();
        // TODO: Implementar ciclo del menú principal
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(String opcion) {
        // TODO: Si es "1" llamar a manejarLogin, si es "2" salir
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        String[] usuarioDatos = manejarUsuario();

        if (login.autenticar(usuarioDatos[0],usuarioDatos[1],datos)){
            System.out.println("Este usuario existe.");
        } else {
            System.out.println("Este usuario no existe.");
        }
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }

    private String[] manejarUsuario(){
        System.out.println("Escriba su usuario: ");
        String nombre = scanner.next();
        System.out.println("Escriba su contraseña: ");
        String contrasena = scanner.next();

        return new String[]{nombre, contrasena};
    }
}