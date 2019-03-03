package processes;

public class Process implements Cloneable {
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

    public int getStartTime() {
        return startTime;
    }

    public void incrementWaitingTime() {
        waitingTime++;
    }

    private void setRunningProgress(int progress) {
        runningProgress = progress;
    }

    private void setWaitingTime(int time) {
        waitingTime = time;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Process clone() throws CloneNotSupportedException {
        return (Process) super.clone();
    }
}
