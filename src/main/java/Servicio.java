import javax.swing.*;

public class Servicio {
    static Calculos operacion = new Calculos();

    public static String validarentrada(String valorUno, String dosValor) {
        int aCantidad = valorUno.length();
        int bCantidad = dosValor.length();
        int agregados;
        String numeros;
        if (aCantidad > bCantidad) {
            agregados = aCantidad - bCantidad;
            for (int i = 0; i < agregados; i++) {
                dosValor = "0" + dosValor;
            }
        } else {
            agregados = bCantidad - aCantidad;
            for (int i = 0; i < agregados; i++) {
                valorUno = "0" + valorUno;
            }
        }
        numeros = String.valueOf(valorUno) + "," + String.valueOf(dosValor);
        return numeros;
    }

    public static void pedirDatos() {
        String primerIngreso;
//        String primerIngreso = "111";
        String segundoIngreso;
//        String segundoIngreso = "101011";
        String resultado;
        String numeros;
        primerIngreso = vPedir("Ingrese su Primer número", "Ingreso de Valores");
        segundoIngreso = vPedir("Ingrese su Segundo número", "Ingreso de Valores");
        numeros = validarentrada(primerIngreso, segundoIngreso);
        Object[] selectOperacion = {"SUMA", "RESTA"};
        int operacionElegida = JOptionPane.showOptionDialog(null, "QUE TIPO DE OPERACION DECEA REALIZAR", "SELECTOR DE OPERACIÓN ", 0,
                JOptionPane.QUESTION_MESSAGE, null, selectOperacion, null);
        if (operacionElegida == 0) {
            resultado = operacion.sumar(numeros);
        } else {
            resultado = operacion.resta(numeros);
        }
        JOptionPane.showMessageDialog(null, "El resultado es ==> "+resultado,"RESULTADO",1,null);
    }

    public static String vPedir(String texto, String titulo) {
        return JOptionPane.showInputDialog(null, texto, titulo, 3);
    }
}
