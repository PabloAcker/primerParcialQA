package ejercicio2;

public class ReservaVuelos {
    private ReservaVuelosHelper reservaVuelosHelper;

    public void setReservaVuelosHelper(ReservaVuelosHelper reservaVuelosHelper) {
        this.reservaVuelosHelper = reservaVuelosHelper;
    }

    //DEV PABLO A.
    private String convertirMesATexto(int mes){
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return meses[mes -1];
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        if(reservaVuelosHelper.existenPasajes(destino, cantidad)) {
            String diaSemana = reservaVuelosHelper.getDay(dia, mes, gestion);
            String mesTexto = convertirMesATexto(mes);
            return String.format("el dia %s %d %s %d existen %d pasajes para %s", diaSemana, dia, mesTexto, gestion, cantidad, destino);
        } else {
            return String.format("no existen suficientes pasajes para %s", destino);
        }
    }
}
