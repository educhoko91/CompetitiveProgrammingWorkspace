import java.util.HashSet;
import java.util.Scanner;


public class Main {

	static HashSet<Integer> angles= new HashSet<Integer>();
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int angleHours = 0;
		int angleMinutes = 0;
		for(int i=0; i<720; i++) {
			angles.add(Math.abs(angleHours-angleMinutes));
			if(i%12==0 && i!=0){
				angleHours+=6;
			}
			angleMinutes+=6;
			
			if(angleHours==360)
				angleHours=0;
			if(angleMinutes==360)
				angleMinutes=0;
		}
		
		
		while(in.hasNextInt()) {
			if(angles.contains(in.nextInt())) 
				System.out.println("Y");
			else
				System.out.println("N");
			
				
		}

	}

}
