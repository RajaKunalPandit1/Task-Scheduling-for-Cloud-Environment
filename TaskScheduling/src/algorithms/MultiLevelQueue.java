package algorithms;
import java.util.*;
import java.util.Map.Entry;


public class MultiLevelQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 int machines = 0,tasks = 0;
		 System.out.println("Enter the machines ");
		 machines = sc.nextInt();
		 System.out.println("Enter the tasks : ");
		 tasks = sc.nextInt();
		 int machinesMIPS[]=new int[machines];
		 System.out.println("Enter the MIPS of the machines ");
		 System.out.println(" ======================== ");
		 for(int i=0;i<machines;i++){ 
			 System.out.println("Enter the MIPS for machine "+(i+1));
			 machinesMIPS[i]=sc.nextInt();
		 }
		 
		 int tasksMI[] = new int[tasks];
		 System.out.println("Enter the MI of the tasks ");
		 System.out.println(" ======================== ");
		 for(int i=0;i<tasks;i++){
			 System.out.println("Enter the MI for Task "+(i+1));
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
		 for(int i=0;i<machines;i++){
		        for(int j=0;j<tasks;j++){
		            int index = machinesMIPS[i]/tasksMI[j];
		            index = matrix[i][j];
				    temp[i][j] = matrix[i][j];
		        }
		 }
		 System.out.println("The generated matrix of the execution time with respect to the machine ");
		 for(int i=0;i<machines;i++){
		        for(int j=0;j<tasks;j++){
		            System.out.print(matrix[i][j]+ " | ");
		        }
		        System.out.println();
		 }
		 
		 Map<Integer,Pair> mp = new HashMap<>();
		 ArrayList<Integer> sjf = new ArrayList<>(tasks);
		 Map<Integer,Integer> mp1 = new HashMap<>();
		 
		 int i=0,j=0;
		    
		    for(i=0;i<tasks;i++){
		        int shortest_task_time = matrix[0][i];
		        int var = 1;
		        
		        for(j=0;j<machines;j++){
		            if(matrix[j][i] < shortest_task_time){
		                shortest_task_time = matrix[j][i];
		                var = j+1;
		            }
		        }
		        mp.put(i,new Pair(shortest_task_time,j));
		        mp1.put(shortest_task_time,i);
		    }
		    int temp1=0;
		    int temp2=0;
		    for (Entry<Integer, Pair> entry1 : mp.entrySet()) {
		    	temp1 = entry1.getValue().mach;
		    	//temp2 = entry1.getValue().temp1;
		    }
		    
//		    for (Entry<Integer, Pair> entry1 : mp.entrySet()) {
//		    	for (Entry<Integer, Integer> entry : mp1.entrySet()) {
//			    	temp1 = entry1.getValue().mach;
//			    	temp2 = entry1.getValue().temp1;
//			    	if(mp.containsKey(entry.getValue())&& !mp.isEmpty()) {
//			    		System.out.println("The task " + (entry.getValue()+1) +  " will execute on machine " + temp1);
//			    		//" for time span "+ temp2
//			    	}
//			    }
		    	for (Entry<Integer, Integer> entry : mp1.entrySet()) {
		    		if(mp.containsKey(entry.getValue())&& !mp.isEmpty()) {
			    		System.out.println("The task " + (entry.getValue()+1) +  " will execute on machine " + temp1);
			    	}
		    	}
//		    	if(mp.containsKey(entry.getValue())&& !mp.isEmpty()) {
//		    		System.out.println("The task " + entry.getValue() +  " will execute on machine " + temp1 + " for time span "+ temp2);
//		    	}
		    }
}
