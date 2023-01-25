package algorithms;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MinMin obj1 = new MinMin();
		MaxMin obj2 = new MaxMin();
		Rasa obj3 = new Rasa();
		Enhanched obj4 = new Enhanched();
		MultiLevelQueue obj5 = new MultiLevelQueue();
		System.out.println("Enter 1 for testing MinMin");
		System.out.println("Enter 2 for testing MaxMin");
		System.out.println("Enter 3 for testing Rasa");
		System.out.println("Enter 4 for testing Enhanched");
		System.out.println("Enter 5 for testing MultiLevel Queue");
		
		System.out.print("Enter your choice: ");
		int n = sc.nextInt();
		
		switch(n) {
		case 1:
			obj1.main(args);
			break;
		case 2:
			obj2.main(args);
			break;
		case 3:
			obj3.main(args);
			break;
		case 4:
			obj4.main(args);
			break;
		case 5:
			obj5.main(args);
		default:
			System.out.println("Wrong input");
		} 
			
	}

}
