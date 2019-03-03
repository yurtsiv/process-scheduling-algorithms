package scheduler;

import processes.Process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Scheduler {
    private int currentTime;
    private ArrayList<Process>
            allProcesses,
            readyProcesses = new ArrayList<>(),
            notReadyProcesses = new ArrayList<>();

    private ScheduleAlgorithm scheduleAlgorithm;

    public Scheduler(ArrayList<Process> allProcesses, ScheduleAlgorithm scheduleAlgorithm) {
        this.allProcesses = Scheduler.cloneProcesses(allProcesses);
        this.scheduleAlgorithm = scheduleAlgorithm;
    }

    private static ArrayList<Process> cloneProcesses(ArrayList<Process> processes) {
        ArrayList<Process> res = new ArrayList<>();
        try {
            for (Process proc : processes) {
                res.add(proc.clone());
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private void splitProcesses() {
        for (Process proc : allProcesses) {
            if (proc.getStartTime() == 0) {
                readyProcesses.add(proc);
            } else {
                notReadyProcesses.add(proc);
            }
        }
    }

    private void updateQueue() {
        for (Process proc : notReadyProcesses) {
            if (proc.getStartTime() == currentTime) {
                readyProcesses.add(proc);
            }
        }

        readyProcesses.removeIf(Process::getIsFinished);
    }

    private boolean areAllProcessesFinished() {
        for (Process proc : allProcesses) {
            if (!proc.getIsFinished()) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<Process> run() {
        splitProcesses();

        while(!areAllProcessesFinished()) {
            updateQueue();
            scheduleAlgorithm.tick(currentTime, readyProcesses);
            currentTime++;
        }

        return allProcesses;
    }
}

