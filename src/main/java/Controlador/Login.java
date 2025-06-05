package Controlador;

import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param nombre nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */

    public Usuario autenticar(String nombre, String clave, DatosLogin datos) {
        // TODO: Buscar si existe un objeto Usuario con esas credenciales.
        ArrayList <Usuario> usuarios = datos.getUsuarios();

        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre) && usuario.getClave().equals(clave)) return usuario;
        }
        return null;
    }

}