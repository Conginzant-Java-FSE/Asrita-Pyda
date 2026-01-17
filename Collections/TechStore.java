package revature;
import java.util.*;

public class TechStore {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Map<String, Integer> current = new HashMap<>();
		Map<String, Integer> incoming = new HashMap<>();
		System.out.println("CurrentStock: ");
		while(s.hasNext()) {
			String p=s.next();
			if (p.equalsIgnoreCase("end")) break;
			int q = s.nextInt(); 
		    current.put(p, current.getOrDefault(p, 0) + q);
		}
		System.out.println("Incoming Stock: ");
		while(s.hasNext()) {
			String p=s.next();
			if (p.equalsIgnoreCase("end")) break;
			int q = s.nextInt(); // must be an integer
		    incoming.put(p, incoming.getOrDefault(p, 0) + q);
		}
		for (Map.Entry<String, Integer> e : incoming.entrySet()) {
            String p = e.getKey();
            int q = e.getValue();
            current.put(p, current.getOrDefault(p, 0) + q);
        }
		Map<String, Integer> sort=new TreeMap<>(current);
		System.out.println("Updated Stock: ");
		int t = 0;
		for (Map.Entry<String, Integer> e : sort.entrySet()) {
			System.out.println(e.getKey() + "->" + e.getValue());
			t+=e.getValue();
		}
		System.out.println("Total Units in Store : " + t);
	}
}
