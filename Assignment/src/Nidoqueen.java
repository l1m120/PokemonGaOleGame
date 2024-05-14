public class Nidoqueen extends GroundPokemon {

	// attributes
	public Nidoqueen(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
			super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	}
	
	// constructor
	
	// setter getter
	
	// other methods
	@Override
	public void move() {
	    System.out.println("Nidoqueen used Earth Power!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}