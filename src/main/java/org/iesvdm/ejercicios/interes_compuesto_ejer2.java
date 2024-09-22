package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class interes_compuesto_ejer2 {

    public static void main(String[] args) {

        BigDecimal p = new BigDecimal("30000");

        BigDecimal r = new BigDecimal("0.05");

        BigDecimal n = new BigDecimal("2");

        System.out.println("c = p(1+r)^n \nc = "+p.toString()+"(1+"+r.toString()+")^"+n.toString());

        BigDecimal c = new BigDecimal(BigInteger.ZERO);

        c = r.add(BigDecimal.ONE);

        c = c.pow(n.intValue());

        c = p.multiply(c);

        c = c.setScale(2, RoundingMode.HALF_UP);

        System.out.println("c = " +c.toString());



    }



}
