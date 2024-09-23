package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class pagos_de_prestamo_amortizable_ejer3 {

    public static void main(String[] args) {

        BigDecimal p = new BigDecimal("200000");

        System.out.println("Préstamo: "+p.setScale(0, RoundingMode.HALF_UP)+"€");

        BigDecimal r = new BigDecimal("0.05"); // 0.05 / 12 para calcular la tasa anual

        System.out.println("Tasa de interés anual: "+r.setScale(2, RoundingMode.HALF_UP)+"%");

        BigDecimal n = new BigDecimal("30");

        System.out.println("Pago mensual: ");

        r = r.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);

        BigDecimal pagoMensual = r.add(BigDecimal.ONE);

        int exponent = -360;

        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        if(exponent < 0){
            // calcular la potencia positiva
            BigDecimal positivePower = r.pow(Math.abs(exponent), mc);
            // tomamos el inverso de esa potencia (1/positivePower)
            BigDecimal result = BigDecimal.ONE.divide(positivePower, mc);
            System.out.println(result);
        }else{
            // calcular el exponente si no es negativo
            BigDecimal result = r.pow(exponent, mc);
            System.out.println(result);
        }

        BigDecimal interesPrimerMes = p.multiply(r);


        System.out.println("Interes del primer mes =  "+p+" x "+r+" = "+interesPrimerMes);




        System.out.println(p.toString());

    }

}
