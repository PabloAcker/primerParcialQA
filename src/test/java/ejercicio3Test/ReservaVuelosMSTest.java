package ejercicio3Test;

import ejercicio3.ReservaVuelosHelperMS;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReservaVuelosMSTest {
    //create Mock
    MockedStatic<ReservaVuelosHelperMS> reservaVuelosHelperMSMocked = Mockito.mockStatic(ReservaVuelosHelperMS.class);

    @Test
    public void verifyReservaDeVuelosConPasajeDispo(){
        //Mockear metodos
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.existenPasajes("La Paz", 2)).thenReturn(true);
    }
}
