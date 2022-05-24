package com.example.aplicatiepaypall.logging;

public enum TimeUnit {
    Nano, Micro, Mili, Sec;

    public static double toTimeUnit(long time, TimeUnit unit)
    {
        switch (unit)
        {
            case Nano:
                return time;
            case Micro:
                return time / 1000.0;
            case Mili:
                return time / 1000000.0;
            case Sec:
                return time / 1000000000.0;
            default:
                return time;
        }
    }
}
