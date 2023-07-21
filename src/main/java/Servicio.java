import javax.swing.*;

public class Servicio {
    static Calculos operacion = new Calculos();

    public static String igualarCantCaracteres(String valorUno, String dosValor) {
        //Declaracion de las variables
        int agregados;
        String numeros;

        //Se evalua la cantidad de caracteres de ambos numeros
        int aCantidad = valorUno.length();
        int bCantidad = dosValor.length();

        //Se compara la cantidad de caracteres entre los numeros
        if (aCantidad > bCantidad) {
            agregados = aCantidad - bCantidad;
           dosValor= rellenarConCeros(dosValor, agregados);
        } else {
            agregados = bCantidad - aCantidad;
            valorUno = rellenarConCeros(valorUno, agregados);
        }

        //Una vez igualada la cant de caracteres ambos numeros se concatenan con una coma entre ellos
        numeros = valorUno + "," + dosValor;
        return numeros;
    }

    //funcion que rellena de ceros de acuerdo a la diferencia de cantidades de caracteres
    public static String rellenarConCeros(String numero, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            numero = "0" + numero;
        }
        return numero;
    }


    public static String vPedir(String texto, String titulo) {
        return JOptionPane.showInputDialog(null, texto, titulo, 3);
    }

    //Funcion para pasar de Decimal a Binario
    public static String decimalAbinario(String entrada) {
        int ultimo;
        String binario = "";
        int sigDividendo;
        String nInicial = entrada;
        String retorno = "";
        int numero = Integer.parseInt(entrada);

        do {
            sigDividendo = numero / 2;//Se divide al numero en dos
            ultimo = numero % 2;// se obtiene el resto de la division del numero y 2
            numero = sigDividendo;//se actualiza el valor a un nuevo numero
            binario = ultimo + binario;// se va acumulando en un String el resto de cada div para armar el binario
        } while (numero > 0);
        return binario;
    }

    // De Binario a decimal
//    public static String binarioAdecimal(String numero) {
//        String nBinario = numero;
//        String resultado;
//        int sumador = 0;
//        int valor = (Integer.parseInt(numero));
//        int ultimo = 0;
//        int hasta = numero.toString().length();
//        for (int i = 0; i < hasta; i++) {
//            ultimo = valor % 10;// se guarda el resto de cada division
//            ultimo = (int) (ultimo * (Math.pow(2, i)));//se multiplica el resto por dos elevado a la potencia que marque i
//            valor = valor / 10;// se actualiza el valor a operar sacando el ultimo digito
//            sumador += ultimo;// se va formando en String el numero decimal
//        }
//        resultado = String.valueOf(sumador);
//        return resultado;
//    }
}
