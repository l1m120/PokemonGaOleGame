// grade 4

public class Pikachu extends ElectricPokemon {
	
	// attributes
    private String zMove;
    
    // constructor
    public Pikachu(String name, int grade, int hp, int poke_ene, String attackType, int attackPower, int defencePower, boolean isDefeated, boolean hasZMove, String zMove) {
        super(name, grade, hp, poke_ene, attackType, attackPower, defencePower, isDefeated, hasZMove);
        this.zMove = zMove;
    }
    
    // setter getter
    public String getZMove() {
        return zMove;
    }

    public void setZMove(String zMove) {
        this.zMove = zMove;
    }
    
    // other methods
    @Override
    public void performZMove() {
    	System.out.println("Pikachu performs Z-Move Gigavolt Havoc!!");
    }
    
    @Override
    public void move() {
      System.out.println("Pikachu used Thunderbolt!");
    }
    
    // tostring
    @Override
    public String toString() {
        return super.toString();
    }
}
