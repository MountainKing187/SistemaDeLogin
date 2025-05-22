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
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
}