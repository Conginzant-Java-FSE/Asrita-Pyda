package revature;
import java.util.*;

public class HospitalER {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	LinkedList<String> emergencyQueue = new LinkedList<>();
        LinkedList<String> normalQueue = new LinkedList<>();
        //PriorityQueue<Patient> erQueue = new PriorityQueue<>(
        //(p1, p2) -> Integer.compare(p2.severity, p1.severity)
    //);
        System.out.println("Patients (name severity):");
        while(s.hasNext()) {
        	String name = s.next();
            int severity = s.nextInt();
            if (severity > 8) {
                emergencyQueue.add(name);
            } else {
                normalQueue.add(name);
            }
        }
        
        while (emergencyQueue.size() > 0) {
            String patient = emergencyQueue.remove();
            System.out.println("Emergency case -> " + patient);
        }

        while (normalQueue.size() > 0) {
            String patient = normalQueue.remove();
            System.out.println("Treating -> " + patient);
        }
    }
}
