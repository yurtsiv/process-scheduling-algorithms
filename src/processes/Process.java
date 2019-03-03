package processes;

public class Process {
    private int id, estimatedRunningTime, startTime, runningProgress = 0, waitingTime = 0;
    private boolean isFinished = false, isRunning = false;

    public Process(int id, int estimatedRunningTime, int startTime) {
        this.id = id;
        this.estimatedRunningTime = estimatedRunningTime;
        this.startTime = startTime;
    }

    public void incrementProgress() {
        runningProgress++;
        if (runningProgress == estimatedRunningTime) {
            isFinished = true;
            isRunning = false;
        }
    }

    public void incrementWaitingTime() {
        waitingTime++;
    }
}
