package org.iesvdm.ejercicios;

import java.math.BigInteger;

public class factorial_ejer1 {

    public static void main(String[] args) {
        // forma que explico el profe
        /* n = new BigInteger("5");
        BigInteger acum = BigInteger.ONE;

        while(n.compareTo(BigInteger.ZERO) > 0){
            acum = acum.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        System.out.println(acum);
        */

        int n = 10; // Cambia este número para calcular el factorial de otro número
        BigInteger factorial = BigInteger.ONE;

        System.out.println("Cálculo del factorial de " + n + ":");

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.println(i + "! = " + factorial);
        }

        System.out.println("El factorial de " + n + " es: " + factorial);

    }

}
