import java.util.Scanner;

public class best {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] a = new int[n];
        System.out.print("Enter time quantum: ");
        int quantum = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
            a[i] = burstTime[i];
            if (burstTime[i] <= 0) {
                System.out.println("Burst time should be greater than zero. Exiting...");
                return;
            }
        }
        scanner.close();

        runRoundRobin(n, burstTime, waitingTime, turnaroundTime, quantum);

        float avgWaitingTime = calculateAverage(waitingTime);
        float avgTurnaroundTime = calculateAverage(turnaroundTime);

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i + 1) + "\t" + a[i] + "\t" + waitingTime[i] + "\t" + turnaroundTime[i]);
        }

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    private static void runRoundRobin(int n, int[] burstTime, int[] waitingTime, int[] turnaroundTime, int quantum) {
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (burstTime[i] > 0) {
                    done = false;
                    int minTime = Math.min(quantum, burstTime[i]);
                    burstTime[i] -= minTime;
                    for (int j = 0; j < n; j++) {
                        if (j != i && burstTime[j] > 0) {
                            waitingTime[j] += minTime;
                        }
                    }
                    if (burstTime[i] == 0) {
                        turnaroundTime[i] = waitingTime[i] + burstTime[i];
                    }
                }
            }
            if (done) {
                break;
            }
        }
    }

    private static float calculateAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (float) sum / values.length;
    }
}
