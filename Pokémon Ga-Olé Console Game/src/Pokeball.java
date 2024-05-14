public class Pokeball extends Ball {
	
    // Attributes

    // constructor
    public Pokeball() {
        super("Pokeball");
    }

    public Pokeball(Pokemon pokemon) {
        super("Pokeball", pokemon);
    }

    public Pokeball(String name, Pokemon pokemon) {
        super(name, pokemon);
    }

    // setter getter
    
    // other methods
    @Override
    public boolean canCatchPokemon(Pokemon target) {
        int pokemonGrade = target.getGrade();
        if (pokemonGrade == 1) {
            System.out.println("Pokeball successfully caught " + target.getName());
            return true;
        } else {
            System.out.println("Pokeball cannot catch " + target.getName());
            return false;
        }
    }
    
    // to string
    @Override
	public String toString() {
		return "Pokeball";
	}
}
