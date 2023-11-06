import java.io.*;
import java.util.Scanner;

class more{
	public static void main(String args[]){

		int i,no_p,BT[],WT[],TT[];
		float avg_wait = 0,avg_turn = 0;
		BT=new int[50];
		TT=new int[50];
		WT=new int[50];
		WT[0]=0;


		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes: ");
		no_p=s.nextInt();

		System.out.println("Enter the Burst Time of the Processes: ");
		for (i=0;i<no_p;i++)
		{
				System.out.println("\tB"+(i+1)+": ");
				BT[i]=s.nextInt();
		}

		for (i=1;i<no_p;i++)
		{
			WT[i] = WT[i-1] + BT[i-1];
			avg_wait+=WT[i];
		}
		avg_wait/=no_p;

		for (i=0;i<no_p;i++)
		{
			TT[i] = WT[i] + BT[i];
			avg_turn+=TT[i];
		}
		avg_turn/=no_p;

		System.out.println("\n*************");
			System.out.println("\tProcesses");
		System.out.println("\n*************");
		System.out.println("\t Process \t BT \t WT \t TT \t");

		for (i=0;i<no_p;i++)
		{
			System.out.println("\tP"+(i+1)+"\t\t" + BT[i] + "\t\t" + WT[i] + "\t\t" + TT[i] + "\t\t");
		}

		System.out.println("Average Waiting Time is: "+avg_wait);
		System.out.println("Average Turn Around Time is: "+avg_turn);
	}
}