package revature;
import java.util.*;
public abstract class magic {
	String name;
	int powerLevel;
	magic(String name, int powerLevel){
		this.name=name;
		this.powerLevel=powerLevel;
	}
	abstract int castSpell(String spellName);
}


class DarkWizard extends magic {
	 
	DarkWizard(String name, int powerLevel){
		super(name, powerLevel);
	}
	int castSpell(String spellName) {
		switch(spellName) {
		case "Crucio":
			return powerLevel *3;
		case "AvadaKedavra":
            return powerLevel * 5;
        default:
            return powerLevel;
		}
	}
}


class HealingWizard extends magic {
	HealingWizard(String name, int powerLevel){
		super(name, powerLevel);
	}
	int castSpell(String spellName) {
		switch(spellName) {
		case "Heal":
			return powerLevel *2;
		case "Revive":
            return powerLevel * 4;
        default:
            return 0;
		}
	}	
	
}


class ElementalWizard extends magic {
	ElementalWizard(String name, int powerLevel){
		super(name, powerLevel);
	}
	int castSpell(String spellName) {
		switch(spellName) {
		case "Fireball":
			return powerLevel *2;
		case "Lightning":
            return powerLevel * 3;
        default:
            return powerLevel;
		}
	}
}


class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Wizard Type: ");
		String wt=s.nextLine();
		
		System.out.print("Name:");
		String n=s.nextLine();
		
		System.out.print("Power Level: ");
        int pl = s.nextInt();
        s.nextLine();

        System.out.print("Spell Name: ");
        String sl = s.nextLine();
        
        magic m;
		switch(wt) {
		case "DarkWizard":
			m=new DarkWizard(n, pl);
			break;
		case "HealingWizard":
			m=new HealingWizard(n, pl);
			break;
		case "ElementalWizard":
			m=new HealingWizard(n, pl);
			break;
		default:
			System.out.println("invalid type");
			return;
			
		}
		
		int d=m.castSpell(sl);

        System.out.println("Wizard: " + m.name);
        System.out.println("Spell Casted: " + sl);
        System.out.println("Damage Dealt: " + d);

        s.close();
	}
}