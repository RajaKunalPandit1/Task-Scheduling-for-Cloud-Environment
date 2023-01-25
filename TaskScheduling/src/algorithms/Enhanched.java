package algorithms;
import java.util.*;
import java.util.Map.Entry;

class Pair{
	int temp1=0;
	int mach=0;
	public Pair(int temp1,int mach) {
		this.temp1=temp1;
		this.mach=mach;
	}
}
public class Enhanched {

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
		
	    enhancedFun(tasks,machines,matrix,temp,tasksMI);
	}
	
	static boolean isClosest(int var, int temp, int pivot){
	    
	    if(Math.abs(var-pivot) < Math.abs(temp-pivot)){
	        return true;
	    }
	    return false;
	}
	
	public static int enhancedFun(int nT, int nM,int enhance[][],int temp[][],int task[]) {
		 int makespan = 0;
		 int var = 0;
		 for(int i=0;i<task.length;i++){
		        var += task[i];
		 }
		 var = var/2;
		 Map<Integer,Pair> mp = new HashMap<>(); //<ll,pair<ll,ll>> mp;
		 int i,j,mach = 0;
		 for(i=0;i<nT;i++) {
			 int temp1 = enhance[i][0];
		     for(j=1;j<nM;j++) {
		    	 if(isClosest(enhance[i][j],temp1,var) == true) {
		    		 temp1 = enhance[i][j];
		             mach = j;
		    	 }
		     }
		     mp.put(i,new Pair(temp1,mach)); // i represents the task number, temp represents the closest execution time to the pivot, to the corresponding 
		 }
		 
		 for (Entry<Integer, Pair> entry : mp.entrySet()) {
			 	System.out.println("The task "+ (entry.getKey()+1) + " with closest execution time "+ entry.getValue().temp1 +  " will execute on the corresponding machine " + entry.getValue().mach);
		 }
		 return 0;
	}
}