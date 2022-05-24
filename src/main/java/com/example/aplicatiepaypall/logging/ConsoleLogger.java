package com.example.aplicatiepaypall.logging;

public class ConsoleLogger implements ILogger {

    public void write(long value)
    {
        System.out.println(String.valueOf(value));
    }

    public void write(String s)
    {
        System.out.println(s);
    }

    public void write(Object...values)
    {
        for(Object o : values)
            System.out.print(o.toString() + " ");
        System.out.println();
    }

    public String writeTime(long value, TimeUnit unit)
    {
        return String.valueOf(TimeUnit.toTimeUnit(value,unit));
    }

    public void writeTime(String s, long value, TimeUnit unit)
    {
        System.out.println( s + " " + TimeUnit.toTimeUnit(value,unit) + " " + unit.toString());
    }

    public void close()
    {

    }

}
