public class Masterball extends Ball {
    
	// attributes

    // constructor
    public Masterball() {
        super("Masterball");
    }

    public Masterball(Pokemon pokemon) {
        super("Masterball", pokemon);
    }

    public Masterball(String name, Pokemon pokemon) {
        super(name, pokemon);
    }
    
    // setter getter

    // other methods
    @Override
    public boolean canCatchPokemon(Pokemon pokemon) {
        int pokemonGrade = pokemon.getGrade();
        if (pokemonGrade >= 1 && pokemonGrade <= 5) {
            System.out.println("Masterball successfully caught " + pokemon.getName());
            return true;
        } else {
            System.out.println("Masterball cannot catch " + pokemon.getName());
            return false;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Masterball";
    }
}
