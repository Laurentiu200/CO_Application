package com.example.aplicatiepaypall.logging;

public interface ILogger {

    public void write(long value);

    public void write(String s);

    public void write(Object...values);

    public String writeTime(long value, TimeUnit unit);

    public void writeTime(String s, long value, TimeUnit unit);

    public void close();
}
