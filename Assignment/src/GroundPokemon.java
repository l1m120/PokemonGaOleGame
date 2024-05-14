public class GroundPokemon extends Pokemon {
	// attributes
	private String defenderType;
	
	// constructor
	
	public GroundPokemon(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	    setDefenderType(defenderType);
	}
	
	public void setDefenderType(String defenderType) {
	    this.defenderType = defenderType;
	}
	
	public String getDefenderType() {
	    return defenderType;
	}
	
	// setter getter
	
	// toString
	public String toString() {
	    return super.toString();
	}
}