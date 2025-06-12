package Modelo;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    private String nombre;
    private String clave;
    private Perfil perfil;

    /**
     * Constructor que inicializa los atributos del usuario.
     *
     * @param nombre nombre del usuario
     * @param clave clave del usuario
     */
    public Usuario(String nombre, String clave, String correo) {
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = new Perfil(correo);
        // TODO: Inicializar atributos nombre y clave
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}