package scheduler;

import processes.Process;

import java.util.ArrayList;

public class FCFS implements ScheduleAlgorithm {
    @Override
    public void tick(int currentTime, ArrayList<Process> readyProcesses) {
        Process currentProcess = readyProcesses.get(0);
        currentProcess.incrementProgress();
    }
}
