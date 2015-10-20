import java.util.Scanner;


public class Main {
	
	static int rows[] = new int[8];
	static int a,b;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

	}
	
	public static void backtrack(int c) {
		if(c==8 && rows[b]==a) {
			
		}
		for(int r=0; r<8; r++){
			if(place(r,c)) {
				rows[c] = r;
			}
		}
	}
	
	public static boolean place(int r, int c) {
		for(int i=0; i<c ; i++) {
			if(rows[i]==r || Math.abs(rows[i]-r)==Math.abs(i-c)){
				return false;
			}
		}
		
		return true;
	}

}
