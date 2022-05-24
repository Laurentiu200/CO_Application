package com.example.aplicatiepaypall.CPU;

public interface IBenchmark {

    public void initialize(int d);

    public void initialize(Object... params);

    public void Warmup();

    public void Run(int option);

    public void Run();

    public void cancel();

    public void clean();

    public void PrintPI();

    public String getResult();

    public void Run(int option1, int option2);

}
