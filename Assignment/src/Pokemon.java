import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Pokemon {

	// attributes
	protected String name;
	protected int grade;
	protected int hp;
	protected int poke_ene;
	protected String attackType;
	protected int attackPower;
	protected int defencePower;
	protected boolean isDefeated;
	protected boolean hasZMove;
	protected int strength = 500;
	private int damage;
	
	// constructors
	public Pokemon() {
	
	}

	public Pokemon(String name, int grade) {
	    this.name = name;
	    this.grade = grade;
	}
	
	public Pokemon(String name) {
	    setName(name);
	}
	
	public Pokemon(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower,
	      boolean isDefeated, boolean hasZMove) {
	    setName(name);
	    setGrade(grade);
	    setHp(hp);
	    setPoke_ene(poke_ene);
	    setAttackType(attackType);
	    setAttackPower(attackPower);
	    setDefencePower(defencePower);
	    this.isDefeated = false;
	    this.hasZMove = false;
	}
	
	// setter getter
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    if (name != null && !name.isEmpty()) {
	      this.name = name;
	    } else {
	      throw new NullPointerException("The name of the Pokemon cannot be null");
	    }
	}
	
	public int getGrade() {
	    return grade;
	}
	
	public void setGrade(int grade) {
	    if (grade >= 1 && grade <= 5) {
	      this.grade = grade;
	    } else {
	      throw new IllegalArgumentException("The grade of the Pokemon must be between 1 and 5");
	    }
	}
	
	public int getHp() {
	    return hp;
	}
	
	public void setHp(int hp) {
	    this.hp = hp;
	}
	
	public int getPoke_ene() {
	    return poke_ene;
	}
	
	public void setPoke_ene(int poke_ene) {
	    this.poke_ene = poke_ene;
	}
	
	public String getAttackType() {
	    return attackType;
	}
	
	public void setAttackType(String attackType) {
	    this.attackType = attackType;
	}
	  
	public int getAttackPower() {
	    return attackPower;
	}
	
	public void setAttackPower(int attackPower) {
	    if (attackPower >= 30 || attackPower <= 210) {
	      this.attackPower = attackPower;
	    } else {
	      throw new IllegalArgumentException("The Attack Power of the Pokemon must be between 30 and 210");
	    }
	}
	
	public int getDefencePower() {
	    return defencePower;
	}
	
	public void setDefencePower(int defencePower) {
	    if (defencePower >= 30 || defencePower <= 130) {
	      this.defencePower = defencePower;
	    } else {
	      throw new IllegalArgumentException("The Defence Power of the Pokemon must be between 30 and 130");
	    }
	}
	
	public boolean getHasZMove() {
	    return hasZMove;
	}
	
	public void setHasZMove(boolean hasZMove) {
	    this.hasZMove = hasZMove;
	}
	
	// other methods
	public void move() {
	    System.out.println("The Pokemon " + this.name + " is performing a move!");
	}
	  
	public void attack(Pokemon target, double effect) {
	    damage = (int) (((getAttackPower() + strength) - target.getDefencePower()) * effect);
	    
	    if ((target instanceof Pikachu) || target instanceof Turtonator) {
	    	target.setHasZMove(true);
	    	System.out.println(target.getName() + " has Z-Move!!!");
	    	damage = damage * 2;
	    	target.performZMove();
	    	takeDamage(target);
	    }
	    else {
	    	System.out.println(target.getName() + " does not have Z-Move!!!");
	    	target.move();
	        takeDamage(target);
	    }
	}
	
	public void takeDamage(Pokemon target) {
	    int currentvalue;
	
	    // Check if damage is greater than or equal to current Poke Energy
	    if (damage >= target.getPoke_ene()) {
	        currentvalue = 0;
	    } else {
	        currentvalue = target.getPoke_ene() - damage;
	    }
	
	    System.out.println(target.getName() + " took " + damage + " damage");
	
	    target.setPoke_ene(currentvalue);
	    System.out.println("Current Poke Energy: " + currentvalue);
	
	    isDefeated(target);
	}
	
	public boolean isDefeated(Pokemon target) {
	    if (target.getPoke_ene() == 0) {
	      return true;
	    } else {
	      return false;
	    }
	}
	
	public void performZMove() {
		  System.out.println("Your Pokemon is performing Z Moves!!");
	}
	
	// tostring
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", grade=" + grade + ", hp=" + hp + ", poke_ene=" + poke_ene + ", attackType="
				+ attackType + ", attackPower=" + attackPower + ", defencePower=" + defencePower + ", isDefeated="
				+ isDefeated + ", hasZMove=" + hasZMove + ", strength=" + strength + ", damage=" + damage + "]";
	}

}