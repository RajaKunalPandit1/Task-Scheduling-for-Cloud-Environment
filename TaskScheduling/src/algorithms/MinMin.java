package algorithms;
import java.util.*;

public class MinMin{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int machines = 0,tasks = 0;
		
		System.out.println("Enter the machines :");
		machines = sc.nextInt();
		
		System.out.println("Enter the tasks : ");
		tasks = sc.nextInt();
		
		int machinesMIPS[]=new int[machines];
		
		System.out.println("Enter the MIPS of the Machines");
		
		System.out.println("==================");
		
		for(int i=0;i<machines;i++){
		    
		    System.out.println("Enter the MIPS for Machine ");
		    machinesMIPS[i]=sc.nextInt();
		}
		
		int tasksMI[] = new int[tasks]; 
		
		System.out.println("Enter the MI of the Tasks");
		
		System.out.println("==================");
		
		for(int i=0;i<tasks;i++){
		    
		    System.out.println("Enter the MI for Task " + (i+1));
		    tasksMI[i]= sc.nextInt();
		    
		}
		
		//Calculation
		int matrix[][] = new int[machines][tasks];
		int temp[][]=new int[machines][tasks];
		
		for(int i=0;i<machines;i++){
		    for(int j=0;j<tasks;j++){
		        matrix[i][j] = machinesMIPS[i]/tasksMI[j];
		        temp[i][j] = matrix[i][j];
		    }
		}
		
		//Output
		System.out.println("The generated Matrix is : ");
		for(int i=0;i<machines;i++){
			for(int j=0;j<tasks;j++)
				System.out.print(matrix[i][j]+" | ");
			System.out.println();
		}
		
		MinMinUtil(tasks,machines,matrix,temp);
	}
	static void MinMinUtil(int nT, int nM, int minMin[][], int tmp[][]) {
		int makespan=0;

		//This array will hold the answer
		int resultTask[] = new int[nT];
		int resultMachine[] = new int[nT];
		int resultTime[] = new int[nT];
		int ptr=-1; //Indicates if result set is full or not

		while(ptr<nT-1){
			int time[] = new int[nT];
			int machine[] = new int[nT];
			for(int j=0;j<nT;j++){
				int minimum = Integer.MAX_VALUE;
				int pos=-1;
				for(int i=0;i<nM;i++){
					if(minMin[i][j]<minimum){
						minimum=minMin[i][j];
						pos=i;
					}
				}
				time[j]=minimum;
				machine[j]=pos;
			}
	
			// Now we find task with minimum time
	
			int minimum=Integer.MAX_VALUE;
			int pos=-1;
	
			for(int j=0;j<nT;j++){
				if(time[j]<minimum){
				minimum=time[j];
				pos=j;
				}
			}
	
			resultTask[++ptr]=pos;
			resultMachine[ptr]=machine[pos];
			resultTime[ptr]=tmp[machine[pos]][pos];
			if(minimum>makespan)
			makespan=minimum;
			// resetting states
	
			for(int i=0;i<nM;i++){
				for(int j=0;j<nT;j++){
					if(j==resultTask[ptr])
					minMin[i][j]=Integer.MAX_VALUE;
					else if(i==resultMachine[ptr] && minMin[i][j]!=Integer.MAX_VALUE) {
						minMin[i][j]+=minimum;
					}
					else
					continue;
				}
			}

		}

		//printing answer
		System.out.print("\nScheduled Task are :\n");
		for(int i=0;i<nT;i++){
			int var1,var2=0;
			var1=resultTask[i]+1;
			var2=resultMachine[i]+1;
			System.out.println("\nTask "+var1 +" Runs on Machine "+var2 +" with Time units : "+ resultTime[i]+" sec"+"\n");
		}

		System.out.println(" Makespan : "+makespan + " sec");
	}
}