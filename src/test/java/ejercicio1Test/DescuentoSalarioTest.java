package ejercicio1Test;

import ejercicio1.DescuentoSalario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DescuentoSalarioTest {
    private final DescuentoSalario descuentoSalario = new DescuentoSalario();

    @ParameterizedTest
    @CsvSource({
            "2000, 0",
            "2001, 5",
            "1999, 0",
            "4000, 5",
            "4001, 15",
            "3999, 5",
            "1000, 0",
            "12000, 15",
            "-500, 0", //exception
            "0, 0"
    })

    public void verifyCalcularDescuento(int salario, int descuentoEsperado){
        if (salario <= 0){
            Assertions.assertThrows(IllegalArgumentException.class, () -> descuentoSalario.calcularDescuento(salario));
        } else {
            int actualResult = descuentoSalario.calcularDescuento(salario);
            Assertions.assertEquals(descuentoEsperado, actualResult, "ERROR! No se reconoce el descuento.");
        }
    }
}
