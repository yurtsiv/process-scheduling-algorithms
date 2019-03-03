package scheduler;

import processes.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SJF implements ScheduleAlgorithm {
    private int prevQeueLength = 0;

    private void sortQueue(ArrayList<Process> readyProcesses) {
        readyProcesses.sort((proc1, proc2) -> {
            if (proc2.getIsRunning()) {
                return 1;
            }

            return proc1.getEstimatedRunningTime() - proc2.getEstimatedRunningTime();
        });
    }

    @Override
    public void tick(int currentTime, ArrayList<Process> readyProcesses) {
        if (readyProcesses.size() > prevQeueLength || currentTime == 0) {
           sortQueue(readyProcesses);
        }

        prevQeueLength = readyProcesses.size();

        Process currentRunnig = readyProcesses.get(0);
        currentRunnig.setIsRunning(true);
        currentRunnig.incrementProgress();
    }
}

