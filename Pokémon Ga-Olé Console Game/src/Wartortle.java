public class Wartortle extends WaterPokemon {
	
	// attributes
	
	// constructor
	public Wartortle(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	}
	
	// setter getter
	
	// other methods
	@Override
	public void move() {
	    System.out.println("Wartortle used Aqua Tail!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}