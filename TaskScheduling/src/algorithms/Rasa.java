package algorithms;
import java.util.*;

public class Rasa {

	public static void main(String[] args){
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
		    int var=i+1;
		    System.out.println("Enter the MI for Task " + var);
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
		        System.out.print(matrix[i][j]+" | ");
		    }
		    System.out.println();
		}

		rasaUtil(machines,tasks,matrix,temp);
		
	}
	
	static void rasaUtil(int machines, int tasks, int rasa[][], int tmp[][]) {
		try {
		MaxMin obj1 = new MaxMin();
		MinMin obj2 = new MinMin();
		Scanner sc = new Scanner(System.in);

//	    int resultTask[] = new int [tasks];
//	    int resultMachines[] = new int[tasks];
//	    int resultTime[]= new int[tasks];
	    
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
		         obj1.MaxMinUtil(machines, tasks, rasa,tmp);
		         if(tasks < 0 || machines < 0) break;
		         tasks--;
		         maxMin=false;
		         minMin=true;
	        }
	        
	        if(minMin){
		         obj2.MinMinUtil(machines, tasks, rasa, tmp);
		         if(tasks < 0 || machines < 0) break;
		         tasks--;
		         minMin=false;
		         maxMin=true;
	        }
	    }
		return;
		}catch(Exception e){
			System.out.println("");
		}
	}		
}
