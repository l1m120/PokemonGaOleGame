public class Ultraball extends Ball {

	// attributes

    // constructor
    public Ultraball() {
        super("Ultraball");
    }

    public Ultraball(Pokemon pokemon) {
        super("Ultraball", pokemon);
    }

    public Ultraball(String name, Pokemon pokemon) {
        super(name, pokemon);
    }

    // setter getter
    
    // other methods
    @Override
    public boolean canCatchPokemon(Pokemon pokemon) {
        int pokemonGrade = pokemon.getGrade();
        if (pokemonGrade >= 1 && pokemonGrade <= 4) {
            System.out.println("Ultraball successfully caught " + pokemon.getName());
            return true;
        } else {
            System.out.println("Ultraball cannot catch " + pokemon.getName());
            return false;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Ultraball";
    }
}
