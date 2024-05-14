public class Greatball extends Ball {

	// attributes

	// constructor
    public Greatball() {
        super("Greatball");
    }

    public Greatball(Pokemon pokemon) {
        super("Greatball", pokemon);
    }

    public Greatball(String name, Pokemon pokemon) {
        super(name, pokemon);
    }
    
    // other methods
    @Override
    public boolean canCatchPokemon(Pokemon pokemon) {
        int pokemonGrade = pokemon.getGrade();
        if (pokemonGrade >= 1 && pokemonGrade <= 2) {
            System.out.println("Greatball successfully caught " + pokemon.getName());
            return true;
        } else {
            System.out.println("Greatball cannot catch " + pokemon.getName());
            return false;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Greatball";
    }
}
