import javax.swing.*;

public class Calculadora {

    Servicio servicio = new Servicio();
    Calculos operacion = new Calculos();

    public void pedirDatos() {
        int continuar;
        int resultadoDecimal;
        String primerIngreso;
        String segundoIngreso;

        String primerValorBinario;
        String segundoValorBinario;

        String resultado;
        String numeros;
        String salida;
        String opreacion;

        do {
            //Se solicita el ingreso de los numero a calcular
            primerIngreso = servicio.vPedir("Ingrese su Primer número", "Ingreso de Valores");
            segundoIngreso = servicio.vPedir("Ingrese su Segundo número", "Ingreso de Valores");

            //se pasa de decimal a binario cada numero ingresados
            primerValorBinario = servicio.decimalAbinario(primerIngreso);
            segundoValorBinario = servicio.decimalAbinario(segundoIngreso);

            // Se igualan la cantidad de caracteres de ambos numeros
            // el retorno de Validar entrada es un String que contiene los dos numeros separados por una coma
            numeros = servicio.igualarCantCaracteres(primerValorBinario, segundoValorBinario);
            //Se crea el array para generar los botones del jopanel
            Object[] selectOperacion = {"SUMA", "RESTA"};

            // Se le pregunta al usuario que operacion desea realizar
            int operacionElegida = JOptionPane.showOptionDialog(null, "QUE TIPO DE OPERACION DESEA REALIZAR", "SELECTOR DE OPERACIÓN ", 0,
                    JOptionPane.QUESTION_MESSAGE, null, selectOperacion, null);

            //Segun la opcion elegida se envia a la funcion el String de los dos numeros
            if (operacionElegida == 0) {
                resultado = operacion.sumar(numeros);
                opreacion = "Sumar";
                resultadoDecimal = Integer.parseInt(primerIngreso) + Integer.parseInt(segundoIngreso);
            } else {
                resultado = operacion.resta(numeros);
                opreacion = "Restar";
                resultadoDecimal = Integer.parseInt(primerIngreso) - Integer.parseInt(segundoIngreso);
            }

            //se arma el mensaje que se vera en el jopanel
            salida = "El primer número es: " + primerIngreso + " Pasado a Bimario es ==> " + primerValorBinario +
                    "\nEl segundo número es: " + segundoIngreso + " Pasado a Bimario es ==> " + segundoValorBinario +
                    "\n\n" + opreacion + " Da como resultado ==>" + resultadoDecimal + " en Decimal" +
                    "\n" + opreacion + " Da como resultado ==>" + resultado + " en Binario";


            JOptionPane.showMessageDialog(null, salida, "Resultado de la operación " + opreacion, 1, null);
            continuar = JOptionPane.showConfirmDialog(null, "Desea Continuar", "Continuamos???", 2, 3);
        } while (continuar == 0);
    }
}
