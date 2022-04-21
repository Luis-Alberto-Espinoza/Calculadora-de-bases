
public class Calculos {
    Servicio servicio = new Servicio();

    public static String sumar(String entrada) {
        String unoNum = entrada.split(",")[0];
        String dosNum = entrada.split(",")[1];
        String salida = "";
        int acarreo = 0;
        int resultado = 0;
        acarreo = 0;
        for (int i = unoNum.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(String.valueOf(unoNum.charAt(i)));
            int b = Integer.parseInt(String.valueOf(dosNum.charAt(i)));
            resultado = a + b;
            if (acarreo == 1) {
                resultado++;
            }
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
            salida = Integer.toString(resultado) + salida;
        }
        if (acarreo == 1) {
            salida = 1 + salida;
        }
        return salida;
    }

    public String complementoA2(String numero) {
        String resultado = "";
        for (int i = numero.length() - 1; i >= 0; i--) {
            char a = ((numero.charAt(i)));
            if (a == '0') {
                resultado = 1 + resultado;
            } else {
                resultado = 0 + resultado;
            }
        }
        resultado = servicio.validarentrada(resultado, "1");
        resultado = sumar(resultado);
        return resultado;
    }

    public String resta(String entrada) {
        String unoValor = entrada.split(",")[0];
        String dosValor = entrada.split(",")[1];

        int longEntrada = unoValor.length();
        int longResultado;
        boolean negativo = false;
        String salida = "";
        String resultado;
        if (Integer.parseInt(unoValor) < Integer.parseInt(dosValor)) {
            negativo= true;
        }
        dosValor = complementoA2(dosValor);
        resultado = sumar((unoValor + "," + dosValor));
        System.out.println(Integer.parseInt(unoValor));
        if (negativo) {
            resultado = complementoA2(resultado);
            negativo = true;
        }
        longResultado = resultado.length();
        if (longEntrada != longResultado) {
            resultado = (resultado.substring(1));
        }
        if (negativo) {
            resultado = "-" + resultado;
        }
        return resultado;
    }
}

