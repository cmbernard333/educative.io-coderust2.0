package com.beardfish.educativeio;

class Timer {
    public void start()
    {
        this.endTime = 0;
        this.startTime = System.nanoTime();
    }

    public void end()
    {
        this.endTime = System.nanoTime();
    }

    public long elapsedNano()
    {
        return endTime - startTime;
    }

    public double elapsedSeconds()
    {
        return (endTime - startTime)/1000000000.0;
    }

    private long startTime;
    private long endTime;
}