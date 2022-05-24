package com.example.aplicatiepaypall.Timing;

public class Timer implements ITimer {
    private long totalTime = 0;
    private long newTime;
    private long endTime;


    public void start()
    {
        newTime = System.nanoTime();
    }

    public long stop()
    {
        if(totalTime == 0)
            return System.nanoTime() - newTime;
        else return totalTime;

    }

    public long pause()
    {
        long curent = System.nanoTime();
        totalTime =totalTime + curent - newTime;
        return curent - newTime;
    }

    public void resume()
    {
        newTime = System.nanoTime();
    }


}
