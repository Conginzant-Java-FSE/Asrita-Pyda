package revature;
import java.util.*;
public class Applicants {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> app1=new ArrayList<String>();
		System.out.println("Applicants:");
		while(s.hasNext()) {
			app1.add(s.next());
		}
		Set<String> app2 = new HashSet<>(app1);
		int dup = app1.size()-app2.size();
		System.out.println("Unique Applicants: " + app2);
		System.out.println("Duplicates Removed: " + dup);
	}
	
}
