import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int[] hand = new int[3];
	while(true){
		hand[0] = in.nextInt();
		hand[1] = in.nextInt();
		hand[2] = in.nextInt();
		if(hand[0]==0 && hand[1]==0 && hand[2]==0)
			break;
		Arrays.sort(hand);
		if(hand[0]==hand[1] && hand[1]==hand[2])  {
			if(hand[0]==13) {
				hand[0]=-1;
			}
			else {
				hand[0]++;
				hand[1]++;
				hand[2]++;
			}
		}
		else if(hand[0]==hand[1]) {
			if(hand[2]!=13) {
				hand[2]++;
			}
			else {
				hand[0]++;
				hand[1]++;
				hand[2] = 1;
			}
			
		}
		else if(hand[1]==hand[2]) {
			if(hand[0]==12 && hand[1]==13) {
				hand[0]=1;
				hand[1]=1;
				hand[2]=1;
			}
			else if(hand[0]+1==hand[1]) {
				hand[0]+=2;
			}
			else {
				hand[0]++;
			}
		}
		else {
			hand[0]=1;
			hand[1]=1;
			hand[2]=2;
		}
		Arrays.sort(hand);
		if(hand[0]==-1)
			System.out.println("*");
		else
			System.out.println(hand[0]+" "+hand[1]+" "+hand[2]);
	}

}
	

	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ladder = new String[181];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int index = 0;
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 13; j++) {
				if (i == 13 && j == 13)
					break;
				if(i==j)
					continue;
				String hand = i + " " + i + " " + j;
				ladder[index] = hand;
				map.put(hand, index);
				index++;
			}
		}
		//ladder[0] = "0 0 0";
		for (int i = 1; i <= 13; i++) {
			String hand = i + " " + i + " " + i;
			ladder[index] = hand;
			map.put(hand, index);
			index++;
		}
		int[] hand = new int[3];
		while (true) {
			hand[0] = in.nextInt();
			hand[1] = in.nextInt();
			hand[2] = in.nextInt();
			Arrays.sort(hand);
			if (hand[0] == 0 && hand[1] == 0 && hand[2] == 0)
				break;
			if (hand[0] == 13 && hand[1] == 13 && hand[2] == 13)
				System.out.println("*");
			else if (hand[0] == hand[1] || hand[1] == hand[2]) {
				index = map.get(hand[0] + " " + hand[1] + " " + hand[2]);
				hand[0]= Integer.parseInt(ladder[index + 1].charAt(0)+"");
				hand[1]= Integer.parseInt(ladder[index + 1].charAt(2)+"");
				hand[2]= Integer.parseInt(ladder[index + 1].charAt(4)+"");
				Arrays.sort(hand);
				System.out.println(hand[0]+" "+hand[1]+" "+hand[2]);
			}
			else {
				System.out.println(ladder[0]);
			}
		}

	}*/

}
