package karthik;
import java.util.*;
import java.util.ArrayList;

public class Factor {
	public static void main(String[] args) {
		
		
		System.out.println("Enter the Number :");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println("---------------- ");
		System.out.print("Factors of a numbers are:");
		 
		//ArrayList a=new ArrayList<>(); 
		ArrayList aa=new ArrayList <>();
		
		for(int i=1;i<=n;i++) {

			if(n%i==0) {
			 
				aa.add(i);// storing the factors in Arraylist
			}
			 
		}
		System.out.println(aa); //printing the Factors
		
		// condition for a Prime number
		if(aa.size()==2) {
			System.err.println(n+" "+"was a prime number");
		}
		else
			System.out.println(n+" "+" was a non prime number");
	}
}

 
