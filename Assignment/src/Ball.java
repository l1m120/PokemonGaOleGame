import java.util.ArrayList;
import java.util.Random;

public class Ball {
	
    // attributes
    private String name;
    private Pokemon pokemon;

    // constructor
    public Ball() {
    	
    }
    
    public Ball(String name) {
    	this.name = name;
    }
    
    public Ball(Pokemon pokemon) {
    	this.pokemon = pokemon;
    }

    public Ball(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    // setter getter
    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	// other methods
    public boolean canCatchPokemon(Pokemon pokemon) {
        return pokemon.getGrade() == 0;
    }

}