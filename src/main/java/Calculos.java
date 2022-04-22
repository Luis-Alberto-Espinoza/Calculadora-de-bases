
public class Calculos {
    Servicio servicio = new Servicio();

    public static String sumar(String entrada) {

        // El parametro ingresado esta formado por dos numeros unidos por una coma
        //se los separa a los numeros
        String unoNum = entrada.split(",")[0];
        String dosNum = entrada.split(",")[1];

        //Declaracion de variables
        String salida = "";
        int acarreo = 0;
        int resultado = 0;
        acarreo = 0;
        //Trabajamos con un for Inverso
        for (int i = unoNum.length() - 1; i >= 0; i--) {

            //se obtiene el caracter segun i
            int a = Integer.parseInt(String.valueOf(unoNum.charAt(i)));
            int b = Integer.parseInt(String.valueOf(dosNum.charAt(i)));
            // se suman dichos caracteres
            resultado = a + b;

            //si la vuelta viene con acarreo, al resultado se le suma uno mas
            if (acarreo == 1) {
                resultado++;
            }

            // Se evalua el resultado
            switch (resultado) {
                case 0:
                case 1:
                    acarreo = 0;
                    break;
                case 2:
                    resultado = 0;
                    acarreo = 1;
                    break;
                case 3:
                    resultado = 1;
                    acarreo = 1;
                    break;
            }

            // se va armando en un String el resultado
            salida = Integer.toString(resultado) + salida;
        }
        //En el caso de que acarreo no tenga con quien ser sumado se agrega al inico del String
        if (acarreo == 1) {
            salida = 1 + salida;
        }
        return salida;
    }


    public String resta(String entrada) {

        // El parametro ingresado esta formado por dos numeros unidos por una coma
        //se los separa a los numeros
        String unoValor = entrada.split(",")[0];
        String dosValor = entrada.split(",")[1];

        int longEntrada = unoValor.length();
        int longResultado;
        boolean negativo = false;
        String salida = "";
        String resultado;

        // SE compara los valores Ingresados para determinar si el resultado sera negativo
        if (Integer.parseInt(unoValor) < Integer.parseInt(dosValor)) {
            negativo= true;
        }
        //Se envia el segundo valor a realizar el complemento a 2
        dosValor = complementoA2(dosValor);

        // Se envia los dos numero ingresados a sumarse
        resultado = sumar((unoValor + "," + dosValor));


        if (negativo) {// si es negativo el resultado
            resultado = complementoA2(resultado);// se envia el resultado a el complemnto a 2
            negativo = true;
        }

        // por el acarreo de la suma el resultado viene con un uno al inicio
        // el cual sera quitado
        longResultado = resultado.length();
        if (longEntrada != longResultado) {
            resultado = (resultado.substring(1));
        }

        //si es negativo se le agrega el simbolo - al inicio
        if (negativo) {
            resultado = "-" + resultado;
        }
        return resultado;
    }
    //Funcion Complemento a 2
    public String complementoA2(String numero) {
        String resultado = "";
        //Trabajamos con un For inverso
        for (int i = numero.length() - 1; i >= 0; i--) {
            //Se invierte el caracter de acuerdo a la posicion que marca i
            char a = ((numero.charAt(i)));
            if (a == '0') {
                resultado = 1 + resultado;
            } else {
                resultado = 0 + resultado;
            }
        }
        // Al resultado invertido se le debe sumar 1
        //pero al no saber cual es la cantidad de caracteres que posee el numero
        //se manda a rellenar los espacios en la funcion Igualar Cantidad De Caracteres
        resultado = servicio.igualarCantCaracteres(resultado, "1");

        //una vez igualado los caracteres se los manda a sumar
        resultado = sumar(resultado);


        return resultado;
    }
}

