package com.example.aplicatiepaypall;

public class Runs {

    private String algorithm;
    private double exec_time;
    private int score;
    private int nr_digits;


    public Runs(int nr_digits, String algorithm, double exec_time, int score) {
        this.nr_digits = nr_digits;
        this.algorithm = algorithm;
        this.exec_time = exec_time;
        this.score = score;
    }


    public Integer getNr_digits() {
        return nr_digits;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public double getExec_time() {
        return exec_time;
    }

    public int getScore() {
        return score;
    }
}
