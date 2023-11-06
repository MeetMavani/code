import java.util.Scanner;

public class last {

    public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter the Number of Processes: ");
		int n = sc.nextInt();

		int[] BurstTime = new int[n];
		int[] WaitingTime = new int[n];
		int[] TurnAroundTime = new int[n];
		int[] A = new int[n];
	
		System.out.println("Enter the Quantum TIme for the Processes: ");
		int Quantum = sc.nextInt();
	
		for(int i = 0; i < n; i++) {
	    	System.out.println("Enter the BurstTime for the Process " + (i + 1) +  ": ");
	    	BurstTime[i] = sc.nextInt();
	    	A[i] = BurstTime[i];
	    	WaitingTime[i] = 0;    
		}
		sc.close();
		while(true) {
	   		boolean done = true;
	    	for(int i = 0; i < n; i++) {
				if(BurstTime[i] > 0) {
		    		done = false;
		    		if(BurstTime[i] > Quantum) {
		        		BurstTime[i] -= Quantum;
		        		for(int j = 0; j < n; j++) {
		    	    		if(j != i && BurstTime[j] > 0) {
			    				WaitingTime[j] += Quantum;
			    			}
		        		}        
		    		} 	
		    		else {
		        		for(int j = 0; j < n; j++) {
		            		if(j != i && BurstTime[j] > 0) {
			       				WaitingTime[j] += BurstTime[i]; 	
			    			}
  		        		}
		        		TurnAroundTime[i] = WaitingTime[i] + A[i];
		        		BurstTime[i] = 0;
		    		}

				}
	    	
	    	}
	    	if(done) {
	    		break;
	    	}
	
		}

		float AvgWaitingTime = 0;
		float AvgTurnAroundTime = 0;
	
		for(int i = 0; i < n; i++) {
	   		AvgWaitingTime += WaitingTime[i];
	    	AvgTurnAroundTime += TurnAroundTime[i];
		}

		System.out.println("Processes\tBurstTime\tWaitingTime\tTurnAroundTime");
		for(int i = 0; i < n; i++) {
	    	System.out.println("P" + (i + 1) + "\t\t" + A[i] + "\t\t" + WaitingTime[i] + "\t\t" + TurnAroundTime[i]);
		}
	
		System.out.println("");
		System.out.println("Average Waiting Time is: " + AvgWaitingTime/n);
		System.out.println("Average TurnAround Time is: " + AvgTurnAroundTime/n);
    }    

}