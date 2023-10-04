package ejercicio2Test;

import ejercicio2.ReservaVuelosHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ReservaVuelosTest {
    ReservaVuelosHelper reservaVuelosHelper = Mockito.mock(ReservaVuelosHelper.class);

    @Test
    public void verifyReservaDeVuelosConPasajesDispo(){
        //Mockear metodos
        Mockito.when(reservaVuelosHelper);
    }
}
