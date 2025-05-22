import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SistemaDeLoginTest {

    @Test
    public void registrarUsuarios(){
        DatosLogin datos = new DatosLogin();
        assertEquals(8, datos.credenciales.size());
    }

    @Test
    public void usuarioExiste(){
        DatosLogin datos = new DatosLogin();
        Login login = new Login();
        assertTrue(login.autenticar("usuario1","clave123",datos));
    }

    @Test
    public void contraseñaIncorrecta(){
        DatosLogin datos = new DatosLogin();
        Login login = new Login();
        assertFalse(login.autenticar("usuario1","contraseñaIncorrecta",datos));
    }

    @Test
    public void ArchivoNoEncontrado(){
        DatosLogin datos = new DatosLogin();
        assertThrows(IOException.class, () -> {
            datos.checkFile();
        });
    }

}