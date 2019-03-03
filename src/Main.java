import processes.Process;
import processes.ProcessesGenerator;
import scheduler.FCFS;
import scheduler.Scheduler;

import java.util.ArrayList;

public class Main {
    private static int
        numberOfSeries = 50,
        seriesLength = 100,
        maxRunningTime = 200,
        maxStartTime = 100;


    public static void main(String[] args) {
        for (int i = 0; i < seriesLength; i++) {
            ArrayList<Process> procSeries = ProcessesGenerator.getSeries(seriesLength, maxRunningTime, maxStartTime);
            Scheduler    scheduler = new Scheduler(
                procSeries,
                new FCFS()
            );

            ArrayList<Process> fcfsRes = scheduler.run();
            System.out.println();
        }
    }
}
