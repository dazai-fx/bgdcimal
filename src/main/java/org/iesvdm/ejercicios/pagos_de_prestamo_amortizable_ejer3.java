package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class pagos_de_prestamo_amortizable_ejer3 {

    public static void main(String[] args) {

        BigDecimal p = new BigDecimal("200000"); // Monto original

        BigDecimal r = new BigDecimal("0.05"); // tasa de interés anual 0.05/12 para calcular la tasa anual

        int n = 30; // Número total de pagos (en meses)

        // Operaciones

        // 1. Convertir la tasa de interés anual a mensual

        r = r.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);

        System.out.println("r = "+r.setScale(10, RoundingMode.HALF_UP)+"%");

        // 2.Calcular el pago mensual (PMT)

        BigDecimal numerador = p.multiply(r);

        BigDecimal denominador = r.add(BigDecimal.ONE);

        int exponente = n * -1;

        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        denominador = BigDecimal.ONE.divide(denominador.pow(Math.abs(exponente), mc), mc);

        denominador = BigDecimal.ONE.subtract(denominador);

        BigDecimal pmt = numerador.divide(denominador, 2, RoundingMode.HALF_UP);

        System.out.println("PMT = "+pmt); // el resultado no corresponde con el ejemplo dado algo esta mal (preguntar al profe)

        

        // 3. Desglosar el pago mensual en:

        //BigDecimal saldoPendiente = p;

        //BigDecimal interesDelMes = saldoPendiente.multiply(r);

        //System.out.println(interesDelMes.setScale(2, RoundingMode.HALF_UP)+"€");



    }

}
