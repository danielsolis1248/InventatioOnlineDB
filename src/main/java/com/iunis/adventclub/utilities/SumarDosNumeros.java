package com.iunis.adventclub.utilities;

import java.util.Scanner;

public class SumarDosNumeros {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        double numero1, numero2, resultado;

        System.out.println("Ingrese el primer numero: ");
        numero1 = sc.nextDouble();

        System.out.println("Ingrese el segundo numero: ");
        numero2 = sc.nextDouble();

        resultado = numero1 + numero2;

        System.out.println("El resultado es: " + resultado);

    }
}
