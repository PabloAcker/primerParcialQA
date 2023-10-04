package ejercicio1;

public class DescuentoSalario {
    private static final int SALARIO_BASICO = 2000;

    public int calcularDescuento(int salario){
        if (salario <= 0){
            throw new IllegalArgumentException("Salario no válido o inexistente");
        }
        if (salario <= SALARIO_BASICO){
            return 0;
        } else if (salario <= 2 * SALARIO_BASICO) {
            return 5;
        } else {
            return 15;
        }
    }
}
