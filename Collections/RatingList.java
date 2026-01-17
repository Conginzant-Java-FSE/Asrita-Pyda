package revature;

import java.util.*;

public class RatingList {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("Ratings: ");
		while(s.hasNextInt()){
			int r = s.nextInt();
			li.add(r);
		}
		
		for (int i = 0; i<li.size(); i++) {
			int num = li.get(i);
			if(num<=0 || num>10) {
				li.remove(Integer.valueOf(num));
				i--;
			}
		}
		System.out.println("Cleaned Ratings: " + li);
		int m = li.get(0);
		int mn = li.get(0);
		double su = 0;
		for(int n: li) {
			if (n>m) m=n;
			if (n < mn) mn = n;
			su+=n;
		}
		double avg = su/li.size();
		System.out.println("Highest Rating: " + m);
		System.out.println("Lowest Rating: " + mn);
		System.out.println("Average Rating : " + avg);
		
	}
	
}

