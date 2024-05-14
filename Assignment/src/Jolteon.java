public class Jolteon extends ElectricPokemon {
	
	// attributes
	public Jolteon(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	  }
	
	// constructor
	
	// setter getter
	
	// other methods
	@Override
	public void move() {
	    System.out.println("Jolteon used Water Fall!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}