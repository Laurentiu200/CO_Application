package com.example.aplicatiepaypall.CPU;



import com.example.aplicatiepaypall.CPU.IBenchmark;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class Gauss implements IBenchmark {
    private BigDecimal pi;
    private int digits;


    public void initialize(int d)
    {
        digits = d;
    }

    public void initialize(Object...params)
    {
        this.digits = (Integer) params[0];
    }

    public void Warmup()
    {
        gaussLegendreBigDecimal(3000);
        PiSpigot.Spigot(String.valueOf(3000));
    }

    public void Run()
    {
        gaussLegendreBigDecimal(3000);
    }
    public void Run(int option)
    {
        if(option == 0)
            gaussLegendreBigDecimal(digits);
        else if(option == 1)
        {
            PiSpigot.Spigot(String.valueOf(digits + 1));
        }
        else
            System.out.println("Invalid option");

    }
    public void gaussLegendreBigDecimal(int digits) {
        MathContext mc = new MathContext(digits);
        BigDecimal two = new BigDecimal(2);
        BigDecimal a = new BigDecimal(1.0d);
        BigDecimal b = new BigDecimal(1.0d ).divide(new BigDecimal(2).sqrt(mc), digits, RoundingMode.CEILING);
        BigDecimal t = new BigDecimal(0.25d);
        BigDecimal p = new BigDecimal(1.0d);
        BigDecimal an1;
        BigDecimal bn1;
        BigDecimal tn1;
        BigDecimal pn1;
        for (long i = 0; i < digits; ++i) {
            an1 = a.add(b, mc).divide(two, digits, RoundingMode.CEILING);
            bn1 = a.multiply(b, mc).sqrt(mc);
            tn1 = t.subtract(p.multiply(a.subtract(an1, mc).pow(2, mc), mc), mc);
            pn1 = p.multiply(two, mc);
            pi =  a.add(b, mc).pow(2, mc).divide(t.multiply(new BigDecimal(4), mc), digits, RoundingMode.CEILING);
            a = an1;
            b = bn1;
            t = tn1;
            p = pn1;
        }
    }



    private BigDecimal sqrt(BigDecimal A, int digits )
    {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        BigDecimal TWO = new BigDecimal(2);

        while(!x0.equals(x1))
        {
            x0 = x1;
            x1 = A.divide(x0, digits, RoundingMode.HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, digits, RoundingMode.HALF_UP);

        }
        return x1;
    }


    public String getResult()
    {
        return "PI" + " = "  + pi;
    }

    @Override
    public void Run(int option1, int option2) {

    }

    public void PrintPI()
    {
        System.out.println(pi);
    }

    public void cancel()
    {

    }

    public void clean()
    {

    }


    //The BBP alghorithm
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    public static String pi_digits(int digits){
        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
            arr[i] = ARRINIT;

        for (int i = digits; i > 0; i-= 14) {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + SCALE * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / SCALE));
            carry = sum % SCALE;
        }
        return pi.toString();
    }

}
