public class Onix extends GroundPokemon {

	//attributes
	
	// constructor
	public Onix(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	}
	
	// setter getter
	
	// other methods
	@Override
	public void move() {
	    System.out.println("Onix used Dig!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}