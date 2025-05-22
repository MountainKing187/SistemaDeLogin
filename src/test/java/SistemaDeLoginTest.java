import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaDeLoginTest {

    @Test
    public void registrarUsuarios(){
        DatosLogin datos = new DatosLogin();
        assertEquals(2, datos.credenciales.size());
    }

    @Test
    public void usuarioExiste(){
        DatosLogin datos = new DatosLogin();
        Login login = new Login();
        assertTrue(login.autenticar("usuario1","clave123",datos));
    }

}