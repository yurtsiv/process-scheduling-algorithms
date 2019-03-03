import processes.Process;
import scheduler.FCFS;
import scheduler.SJF;
import scheduler.Scheduler;

import java.util.ArrayList;

public class Main {
    private static int
        numberOfSeries = 1,
        seriesLength = 5,
        maxRunningTime = 100,
        maxStartTime = 30;


    public static void main(String[] args) {
        for (int i = 0; i < seriesLength; i++) {
//            ArrayList<Process> procSeries = ProcessesGenerator.getSeries(seriesLength, maxRunningTime, maxStartTime);
            ArrayList<Process> procSeries = new ArrayList<>();
            procSeries.add(new Process(1, 50, 0));
            procSeries.add(new Process(2, 40, 1));
            Scheduler scheduler = new Scheduler();

            ArrayList<Process> fcfsRes = scheduler.run(procSeries, new FCFS());
            ArrayList<Process> sjfRes = scheduler.run(procSeries, new SJF());
            System.out.println();
        }
    }
}
