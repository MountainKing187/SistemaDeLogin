import Modelo.DatosLogin;
import Controlador.Login;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SistemaDeLoginTest {

    @Test
    public void registrarUsuarios(){
        DatosLogin datos = new DatosLogin();
        assertEquals(9, datos.credenciales.size());
    }

    @Test
    public void usuarioExiste(){
        DatosLogin datos = new DatosLogin();
        Login login = new Login();
        assertNotNull(login.autenticar("usuario1","clave123",datos));
    }

    @Test
    public void contraseñaIncorrecta(){
        DatosLogin datos = new DatosLogin();
        Login login = new Login();
        assertNull(login.autenticar("usuario1","contraseñaIncorrecta",datos));
    }

    @Test
    public void ArchivoNoEncontrado(){
        DatosLogin datos = new DatosLogin();

        datos.manejoDeLoginText(true);
        assertFalse(datos.getLoginExist());
        datos.manejoDeLoginText(false);
        assertTrue(datos.getLoginExist());
    }

}