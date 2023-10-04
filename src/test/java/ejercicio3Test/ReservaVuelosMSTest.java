package ejercicio3Test;

import ejercicio3.ReservaVuelosHelperMS;
import ejercicio3.ReservaVuelosMS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

//NOTA: Al ser mocks estaticos se debe probar los test uno por uno y no correr todos de golpe
public class ReservaVuelosMSTest {
    //create Mock
    MockedStatic<ReservaVuelosHelperMS> reservaVuelosHelperMSMocked = Mockito.mockStatic(ReservaVuelosHelperMS.class);

    @Test
    public void verifyReservaDeVuelosConPasajeDispo(){
        //Mockear metodos
        //ejemplos:
        //input: La Paz, 2 , 29 , 5 , 2023
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.existenPasajes("La Paz", 2)).thenReturn(true);
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.getDay(29, 5, 2023)).thenReturn("Lunes");

        ReservaVuelosMS reservaVuelosMS = new ReservaVuelosMS();

        //output: "el dia Lunes 29 Mayo 2023 existen
        String actualResult = reservaVuelosMS.reservaVuelo("La Paz", 2, 29, 5, 2023);
        String expectedResult = "el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz";

        Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva del pasaje es incorrecta.");
    }

    @Test
    public void verifyReservaDeVuelosSinPasajeDispo(){
        //Mockear metodos
        //ejemplos:
        //input: La Paz, 10 , 10 , 7 , 2023
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.existenPasajes("La Paz", 10)).thenReturn(false);
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.getDay(10, 7, 2023)).thenReturn("Lunes");

        ReservaVuelosMS reservaVuelosMS = new ReservaVuelosMS();

        //output: "no existen suficientes pasajes para La Paz"
        String actualResult = reservaVuelosMS.reservaVuelo("La Paz", 10, 10, 7, 2023);
        String expectedResult = "no existen suficientes pasajes para La Paz";

        Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva del pasaje es incorrecta.");
    }

    @Test
    public void verifyReservaDeVuelosOtroDestino(){
        //Mockear metodos
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.existenPasajes("Santa Cruz", 2)).thenReturn(true);
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.getDay(17, 3, 2023)).thenReturn("Miercoles");

        ReservaVuelosMS reservaVuelosMS = new ReservaVuelosMS();

        String actualResult = reservaVuelosMS.reservaVuelo("Santa Cruz", 2, 17, 3, 2023);
        String expectedResult = "el dia Miercoles 17 Marzo 2023 existen 2 pasajes para Santa Cruz";

        Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva del pasaje es incorrecta.");
    }

    @Test
    public void verifyReservaDeVuelosConMesCorrecto(){
        //Mockear metodos
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.existenPasajes("Cochabamba", 3)).thenReturn(true);
        reservaVuelosHelperMSMocked.when(() -> ReservaVuelosHelperMS.getDay(3, 10, 2023)).thenReturn("Jueves");

        ReservaVuelosMS reservaVuelosMS = new ReservaVuelosMS();

        String actualResult = reservaVuelosMS.reservaVuelo("Cochabamba", 3, 3, 10, 2023);
        String expectedResult = "el dia Jueves 3 Octubre 2023 existen 3 pasajes para Cochabamba";

        Assertions.assertEquals(expectedResult, actualResult, "ERROR! La reserva del pasaje es incorrecta.");
    }
}
