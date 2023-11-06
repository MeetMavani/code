import java.util.Scanner;

public class RR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] a = new int[n];
        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            a[i] = burstTime[i];
            waitingTime[i] = 0;
        }
        sc.close();

        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (burstTime[i] > 0) {
                    done = false;
                    if (burstTime[i] > quantum) {
                        burstTime[i] -= quantum;
                        for (int j = 0; j < n; j++) {
                            if (j != i && burstTime[j] > 0) {
                                waitingTime[j] += quantum;
                            }
                        }
                    } else {
                        for (int j = 0; j < n; j++) {
                            if (j != i && burstTime[j] > 0) {
                                waitingTime[j] += burstTime[i];
                            }
                            
                        }
                        burstTime[i] = 0;
                        turnaroundTime[i] = waitingTime[i] + a[i];
                        
                    }
                }
            }
            if (done) {
                break;
            }
        }

        float avgWaitingTime = calculateAverage(waitingTime);
        float avgTurnaroundTime = calculateAverage(turnaroundTime);

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i + 1) + "\t" + a[i] + "\t" + "\t"  + waitingTime[i] + "\t" + "\t"  + turnaroundTime[i]);
        }

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    private static float calculateAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (float) sum / values.length;
    }
}
