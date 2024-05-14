public class WaterPokemon extends Pokemon {
	
	// attributes
	private String defenderType;
	
	// constructor
	public WaterPokemon(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove) {
	    super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
	    setDefenderType(defenderType);
	}
	
	// setter getter
	public void setDefenderType(String defenderType) {
	    this.defenderType = defenderType;
	}
	
	public String getDefenderType() {
	    return defenderType;
	}
	
	// toString
	public String toString() {
	    return super.toString();
	}
}