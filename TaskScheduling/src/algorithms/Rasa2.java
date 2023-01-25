package algorithms;

import java.util.*;

public class Rasa2 {

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
		    
		    System.out.println("Enter the MI for Task " + i+1);
		    tasksMI[i]= sc.nextInt();
		    
		}
		
		int matrix[][] = new int[machines][tasks];
		int temp[][]=new int[machines][tasks];
		
		for(int i=0;i<machines;i++){
		    for(int j=0;j<tasks;j++){
		        matrix[i][j] = machinesMIPS[i]/tasksMI[j];
		        temp[i][j] = matrix[i][j];
		    }
		}
		
		
		System.out.println("The generated Matrix is : ");
		
		for(int i=0;i<machines;i++){
		    for(int j=0;j<tasks;j++){
		        System.out.println(matrix[i][j]);
		    }
		    System.out.println();
		}

		rasaUtil1(machines,tasks,matrix,temp);
	}
	
	static void MinMinUtil(int nT, int nM, int minMin[][], int tmp[][]) {
		int makespan=0;
//		System.out.println(" Original Data ");
//
//		for(int i=0;i<nM;i++){
//			for(int j=0;j<nT;j++)
//				System.out.print(minMin[i][j]+" | ");
//			System.out.println();
//		}

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
			System.out.println("\nTask "+resultTask[i]+1 +" Runs on Machine "+resultMachine[i]+1 +" with Time units : "+ resultTime[i]+"\n");
		}

		System.out.println(" Makespan : "+makespan + " units");
	}
	
	static void MaxMinUtil(int nT, int nM, int maxMin[][], int tmp[][]) {
		//int nT,nM;//number of tasks , number of machines
		System.out.println("Enter number of machines and tasks");
		Scanner sc = new Scanner(System.in);

		int makespan=0;
		System.out.println("Fill Data");
//		for(int i=0;i<nM;i++) {
//			for(int j=0;j<nT;j++){
//				maxMin[i][j] = sc.nextInt();
//				tmp[i][j]=maxMin[i][j];
//			}
//		}

		// visualise data
		System.out.println("Original Data ");

		for(int i=0;i<nM;i++){
			for(int j=0;j<nT;j++) {
				System.out.print(maxMin[i][j]+" | ");
			}
			System.out.println();
		}

		//This array will hold the answer
		int resultTask[] = new int[nT];
		int resultMachine[] = new int[nT];
		int resultTime[] = new int[nT];

		int ptr=-1; //Indicates if result set is full or not

		while(ptr<nT-1){
		int time[] = new int[nT];
		int machine[] = new int[nT]; //stores minimum time w.r.t machine of each task
		for(int j=0;j<nT;j++){
			int minimum = Integer.MAX_VALUE;
			int pos=-1;
			for(int i=0;i<nM;i++){
				if(maxMin[i][j]<minimum){
					minimum=maxMin[i][j];
					pos=i;
				}
			}
			time[j]=minimum;
			machine[j]=pos;
		}

		// Now we find task with maximum time

		int maximum=Integer.MIN_VALUE;
		int pos=-1;

		for(int j=0;j<nT;j++){
			if(time[j]>maximum && time[j] != Integer.MAX_VALUE){
				maximum=time[j];
				pos=j;
			}
		}

		resultTask[++ptr]=pos;
		resultMachine[ptr]=machine[pos];
		resultTime[ptr]=tmp[machine[pos]][pos];
		if(maximum>makespan)makespan=maximum;
		// resetting states

		for(int i=0;i<nM;i++){
			for(int j=0;j<nT;j++){
				if(j==resultTask[ptr])maxMin[i][j]=Integer.MAX_VALUE;
				else if(i==resultMachine[ptr] && maxMin[i][j]!=Integer.MAX_VALUE)
					maxMin[i][j]+=maximum;
				else
					continue;
			}
		}

	}

		//printing answer
		System.out.println("Scheduled Task are :");
		for(int i=0;i<nT;i++){
			System.out.println("Task "+resultTask[i]+1+" Runs on Machine "+resultMachine[i]+1+" with Time units : "+resultTime[i]);
		}

		System.out.println("Total elapsed time : "+makespan+" units");
		return;
	}
	
	static void rasaUtil1(int machines, int tasks, int rasa[][], int tmp[][]) {
		MaxMin obj1 = new MaxMin();
		MinMin obj2 = new MinMin();
		Scanner sc = new Scanner(System.in);

	    
	    System.out.println("The original Data is : ");
	    
	    for(int i=0;i<machines;i++){
	        for(int j=0;j<tasks;j++){
	            System.out.print(rasa[i][j]+" | ");
	        }
	        System.out.println();
	    }
	    int resultTask[] = new int [tasks];
	    int resultMachines[] = new int[tasks];
	    int resultTime[]= new int[tasks];
	    
	    boolean maxMin = false, minMin = false;
	    
	    if(machines % 2 == 0){
	        maxMin = true;
	    }else{
	        minMin = true;
	    }
	    
	    while(true){
	        
	        if(tasks == 0){
	            break;
	        }
	        
	        if(maxMin){
		         MaxMinUtil(tasks,machines,rasa,tmp);
		         tasks--;
		         maxMin=false;
		         minMin=true;
	        }
	        
	        if(minMin){
		         MinMinUtil(machines, tasks, rasa, tmp);
		         tasks--;
		         minMin=false;
		         maxMin=true;
	        }
	    }
		return;
	}		

}
