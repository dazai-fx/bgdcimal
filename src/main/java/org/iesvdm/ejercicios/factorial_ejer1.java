package org.iesvdm.ejercicios;

import java.math.BigInteger;

public class factorial_ejer1 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("5");
        BigInteger acum = BigInteger.ONE;

        while(n.compareTo(BigInteger.ZERO) > 0){
            acum = acum.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        System.out.println(acum);

    }

}
