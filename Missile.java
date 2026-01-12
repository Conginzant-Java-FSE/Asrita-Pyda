package revature;
import java.util.Scanner;
public abstract class Missile {
	String missileId;
	int range;
	Missile(String missileId, int range){
		this.missileId=missileId;
		this.range= range;
	}
	abstract boolean launch(int threatLevel, boolean hasClearance); 
}


class NuclearMissile extends Missile {
	NuclearMissile(String missileId, int range){
		super(missileId, range);
	}
	boolean launch(int threatLevel, boolean hasClearance) {
		System.out.println("Missile ID: " + missileId);
		if (threatLevel>=9 && hasClearance) {
			System.out.println("Launch Status: APPROVED");
            System.out.println("Nuclear missile launched successfully.");
            return true;
		} else {
			System.out.println("Launch Status: DENIED");
            if (threatLevel < 9) {
                System.out.println("Reason: Threat level insufficient for nuclear launch");
            }else {
            	System.out.println("Reason: Command clearance not provided");
            }
            return false;
		} 
	}
}



class TorpedoMissile extends Missile {
	TorpedoMissile(String missileId, int range){
		super(missileId,range);
	}
	boolean launch(int threatLevel, boolean hasClearance) {
		System.out.println("Missile ID: " + missileId);
        if (threatLevel >= 5) {
            System.out.println("Launch Status: APPROVED");
            System.out.println("Torpedo launched successfully.");
            return true;
        } else {
            System.out.println("Launch Status: DENIED");
            System.out.println("Reason: Threat level insufficient for torpedo launch");
            return false;
        }
	}
}



class DefenseInterceptor extends Missile {
	DefenseInterceptor(String missileId, int range){
		super(missileId,range);
	}
	boolean launch(int threatLevel, boolean hasClearance) {

		System.out.println("Missile ID: " + missileId);
        if (threatLevel >= 3) {
            System.out.println("Launch Status: APPROVED");
            System.out.println("Interceptor launched successfully.");
            return true;
        } else {
            System.out.println("Launch Status: DENIED");
            System.out.println("Reason: Threat level insufficient for interceptor launch");
            return false;
        }
	}
}


class Main1{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Missile Type: ");
        String mt = scanner.nextLine();

        System.out.print("Missile ID: ");
        String mId = scanner.nextLine();

        System.out.print("Threat Level: ");
        int tl = scanner.nextInt();

        System.out.print("Clearance (true/false): ");
        boolean hc = scanner.nextBoolean();

        Missile missile;

        switch (mt) {
            case "NuclearMissile":
                missile = new NuclearMissile(mId, 5000);
                break;
            case "TorpedoMissile":
                missile = new TorpedoMissile(mId, 100);
                break;
            case "DefenseInterceptor":
                missile = new DefenseInterceptor(mId, 200);
                break;
            default:
                System.out.println("Invalid missile type");
                scanner.close();
                return;
        }

        System.out.println();
        missile.launch(tl, hc);
        scanner.close();
	}
}