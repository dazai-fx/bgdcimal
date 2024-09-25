package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class pagos_de_prestamo_amortizable_ejer3 {

    public static void main(String[] args) {

        BigDecimal p = new BigDecimal("200000"); // Monto de prestamo original

        BigDecimal annualRate = new BigDecimal("0.05"); // tasa de interés anual

        int paymentsPerMonth = 30;

        BigDecimal pmt = calculatePMT(p,annualRate,paymentsPerMonth);

        System.out.println("Préstamo: "+p);

        System.out.println("Tasa de interés anual: "+annualRate);

        System.out.println("Pago mensual: "+pmt);

        BigDecimal r = calculateMonthlyInterestRate(annualRate);

        BigDecimal newBalance = p;

        System.out.println("Esquema de amortización" +
                         "\n_______________________\nMes Pago\t\tPrincipal\tInterés\tBalance");

        int i = 1;

        while (newBalance.compareTo(BigDecimal.ZERO) > 0) {

            BigDecimal monthInterestPayment = p.multiply(r);// interes del mes = saldo pendiente x r

            // principal del mes = PMT - Intereses del mes
            BigDecimal mainOfTheMonth = pmt.subtract(monthInterestPayment);

            newBalance = p.subtract(mainOfTheMonth); // nuevo saldo = saldo pendiente - principal mes

            p=newBalance;

            // formateando la salida
            System.out.println(i+"\t"+pmt+"\t\t"+mainOfTheMonth.setScale(2, RoundingMode.HALF_UP)+
                    "\t"+monthInterestPayment.setScale(2, RoundingMode.HALF_UP)+"\t"
                    +newBalance.setScale(2, RoundingMode.HALF_UP));

            i++;

        }

    }

    public static BigDecimal calculateMonthlyInterestRate(BigDecimal annualRate){
        //1. Tasa de interés mensual: rate = annualRate / 12
        BigDecimal monthsInYear = new BigDecimal(12);
        return annualRate.divide(monthsInYear, MathContext.DECIMAL128);
    }

    public static BigDecimal calculatePMT(BigDecimal p, BigDecimal annualRate, int paymentsPerMonth){

        BigDecimal monthlyRate = calculateMonthlyInterestRate(annualRate); // rate as a decimal

        // 2. Número total de pagos: n = years * 12
        int totalPayments = paymentsPerMonth * 12;

        // 3. (1 + r)^n
        BigDecimal one = BigDecimal.ONE;

        BigDecimal onePlusRate = one.add(monthlyRate); // (1 + r)

        BigDecimal power = onePlusRate.pow(totalPayments, MathContext.DECIMAL128); // (1 + r)^n

        // 4. Numerador: P * r * (1 + r)^n
        BigDecimal numerator = p.multiply(monthlyRate).multiply(power);

        // 5. Denominador: (1 + r)^n - 1
        BigDecimal denominator = power.subtract(one);

        // 6. PMT = numerador / denominador
        BigDecimal pmt = numerator.divide(denominator, RoundingMode.HALF_UP);

        return pmt.setScale(2, RoundingMode.HALF_UP); // Redondeamos a 2 decimales

    }




}
