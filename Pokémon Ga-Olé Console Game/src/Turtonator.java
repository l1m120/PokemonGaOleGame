public class Turtonator extends FirePokemon { 

	// attributes
	private String zMove;
		
	// constructors
	public Turtonator(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove, String zMove) {
	      super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	    this.zMove = zMove;
	}
	
	//setter getter
	public String getZMove() {
	    return zMove;
	}
	
	public void setZMove(String zMove) {
	    this.zMove = zMove;
	}
	
	// other methods
	public void performZMove() {
	      System.out.println("Turtonator performs Z-Move Inferno Overdrive!!");
	}
	  
	@Override
	public void move() {
	    System.out.println("Turtonator used Inferno Overdrive!");
	}
	
	// toString
	@Override
	public String toString() {
	    return super.toString();
	}
}