package scheduler;

import processes.Process;

import java.util.ArrayList;

public class SJFPreemptive extends SJF implements ScheduleAlgorithm {
    @Override
    public void tick(int currentTime, ArrayList<Process> readyProcesses) {
        super.tick(
            currentTime,
            readyProcesses,
            (proc1, proc2) -> proc1.getEstimatedRunningTime() - proc2.getEstimatedRunningTime()
        );
    }
}
