public class Spheal extends WaterPokemon {

	// attributes
	
	// constructor
	public Spheal(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	}
	
	// setter getter
	
	// other methods
	@Override
	public void move() {
	    System.out.println("Spheal used Hyper Voice!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}