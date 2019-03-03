package processes;

public class Process {
    private int id, estimatedRunningTime, startTime, runningProgress = 0;
    boolean isFinished = false, isRunning = false;

    public Process(int id, int estimatedRunningTime, int startTime) {
        this.id = id;
        this.estimatedRunningTime = estimatedRunningTime;
        this.startTime = startTime;
    }


}
