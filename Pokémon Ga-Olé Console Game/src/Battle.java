import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Battle {

  // attributes
  private Button button;
  private Pokemon pokemon;
  private Ball ball;
  private ArrayList<Pokemon> plist1 = new ArrayList<Pokemon>();
  private ArrayList<Pokemon> plist2 = new ArrayList<Pokemon>();
  private ArrayList<Pokemon> plist3 = new ArrayList<Pokemon>();
  private ArrayList<Ball> blist = new ArrayList<Ball>();
  private String P_pokemon1;
  private String P_pokemon2;
  private String Opp_pokemon1;
  private String Opp_pokemon2;
  private Game game;
  double effectiveness1 = 0.0;
  double effectiveness2 = 0.0;
  double effectiveness3 = 0.0;
  double effectiveness4 = 0.0;
  private int turnCount;
  private boolean extraBattleFlag = false;  // Flag to track extra battle
  
  Button continue_game = new Button();
  Button buttonTurn = new Button();
  Scanner input = new Scanner(System.in);
  Player player = new Player();

  // constructor
  public Battle() {

  }
  
  public Battle(Game game) {
	  this.game = game;
  }

  public Battle(Pokemon pokemon) {
    this.pokemon = pokemon;
  }
  
  public Battle(Player player) {
	  this.player = player;
  }

  // setter getter

  // other methods
  public void requestInput() {
	  String pname = player.inputPlayerName();
	  player.setName(pname);
  }
  
  public void startBattle() {
	  continue_game.continue_button();
	  System.out.println("\nSmash the buttons to win an attacking chance!");

	  turnCount = 0;
	  looping(); 
  }

  public void looping() {
	  int totalPresses = buttonTurn.handleKeyInput();
	  attackTurn(totalPresses);
	  turnCount++;
  }

  public void addPokemon1() {
      Zygarde Zygarde = new Zygarde("Zygarde", 5, 200, 3820, "GROUND", 104, 121, false, false);
      plist1.add(Zygarde);

      Solgaleo Solgaleo = new Solgaleo("Solgaleo", 5, 249, 4820, "STEEL", 180, 141, false, false);
      plist1.add(Solgaleo);

      Pikachu Pikachu = new Pikachu("Pikachu", 4, 113, 2420, "ELECTRIC", 66, 53, false, true, "Gigavolt Havoc");
      plist1.add(Pikachu);

      Turtonator Turtonator = new Turtonator("Turtonator", 4, 137, 3260, "FIRE", 110, 181, false, true, "Inferno Overdrive");
      plist1.add(Turtonator);

      Jolteon Jolteon = new Jolteon("Jolteon", 3, 127, 3080, "ELECTRIC", 117, 66, false, false);
      plist1.add(Jolteon);

      Blastoise Blastoise = new Blastoise("Blastoise", 3, 141, 3120, "WATER", 81, 107, false, false);
      plist1.add(Blastoise);

      Charmeleon Charmeleon = new Charmeleon("Charmeleon", 2, 107, 2200, "FIRE", 77, 57, false, false);
      plist1.add(Charmeleon);

      Onix Onix = new Onix("Onix", 2, 89, 2200, "GROUND", 47, 157, false, false);
      plist1.add(Onix);

      Charmander Charmander = new Charmander("Charmander", 1, 79, 1560, "FIRE", 46, 36, false, false);
      plist1.add(Charmander);

      Squirtle Squirtle = new Squirtle("Squirtle", 1, 63, 1580, "WATER", 44, 56, false, false);
      plist1.add(Squirtle);
      
      Spheal Spheal = new Spheal("Spheal", 1, 108, 1520, "WATER", 49, 45, false, false);
      plist1.add(Spheal);
      
      Wartortle Wartortle = new Wartortle("Wartortle", 2, 108, 2200, "WATER", 61, 77, false, false);
      plist1.add(Wartortle);
      
      Steelix Steelix = new Steelix("Steelix", 3, 148, 3120, "STEEL", 99, 210, false, false);
      plist1.add(Steelix);
      
      Nidoqueen Nidoqueen = new Nidoqueen("Nidoqueen", 4, 169, 3320, "GROUND", 90, 104, false, false);
      plist1.add(Nidoqueen);
      
      Lunala Lunala = new Lunala("Lunala", 5, 249, 4820, "STEEL", 180, 118, false, false);
      plist1.add(Lunala);

      addPokemon2();

      System.out.println(plist1.toString());

    }

    // make a copy of the plist
    public void addPokemon2() {
      plist2.addAll(plist1);
      System.out.println(plist2.toString());
      addBall();
    }

    public void addBall() {
      Pokeball Pokeball = new Pokeball();
      Greatball Greatball = new Greatball();
      Ultraball Ultraball = new Ultraball();
      Masterball Masterball = new Masterball();

      blist.add(Pokeball);
      blist.add(Greatball);
      blist.add(Ultraball);
      blist.add(Masterball);

      System.out.println(blist.toString());

    }

    public void determinePokemon(int totalPresses) {
      Collections.sort(plist1, new Comparator<Pokemon>() {
        @Override
        public int compare(Pokemon p1, Pokemon p2) {
          return p2.getGrade() - p1.getGrade();
        }
      });

      List<List<String>> pokemonListByGrade = new ArrayList<>();
      List<String> grade1 = new ArrayList<>();
      List<String> grade2 = new ArrayList<>();
      List<String> grade3 = new ArrayList<>();
      List<String> grade4 = new ArrayList<>();
      List<String> grade5 = new ArrayList<>();

      for (Pokemon pokemon : plist1) {
        switch (pokemon.getGrade()) {
          case 1:
            grade1.add(pokemon.getName());
            break;
          case 2:
            grade2.add(pokemon.getName());
            break;
          case 3:
            grade3.add(pokemon.getName());
            break;
          case 4:
            grade4.add(pokemon.getName());
            break;
          case 5:
            grade5.add(pokemon.getName());
            break;
        }
      }

      pokemonListByGrade.add(grade1);
      pokemonListByGrade.add(grade2);
      pokemonListByGrade.add(grade3);
      pokemonListByGrade.add(grade4);
      pokemonListByGrade.add(grade5);

      if (totalPresses > 40) {
        generateRandomPokemon(grade5, grade4);
      } else if (totalPresses > 30) {
        generateRandomPokemon(grade4, grade3);
      } else if (totalPresses > 25) {
        generateRandomPokemon(grade3, grade2);
      } else {
        generateRandomPokemon(grade2, grade1);
      }
    }
    
    public void generateRandomPokemon(List<String> plist1, List<String> plist2) {
        List<Pokemon> chosenPokemon = getRandomPokemonList(plist1);

        // Allow the user to choose one Pokémon
        Scanner scanner = new Scanner(System.in);
	    int choice = 0;
	
	    // Keep prompting the user until a valid integer is entered
	    while (true) {
	          try {
	              System.out.println("Which Pokemon suits you the best? (1-3): ");
	              choice = scanner.nextInt();
	              break; // Exit the loop if a valid integer is entered
	          } catch (InputMismatchException e) {
	              // Clear the scanner buffer in case of an exception
	              scanner.nextLine();
	              System.out.println("Invalid input. Please enter a number.");
	          }
	     }
	
	     if (choice >= 1 && choice <= 3) {
	          P_pokemon1 = chosenPokemon.get(choice - 1).getName();
	     } else {
	          System.out.println("Invalid choice. Choosing the first Pokemon by default.");
	          P_pokemon1 = chosenPokemon.get(0).getName();
	     }

         // Continue with P_pokemon2 and other logic
         P_pokemon2 = getRandomPokemon(plist2);
         while (P_pokemon1.equals(P_pokemon2)) {
        	 P_pokemon2 = getRandomPokemon(plist2);
         }

         while (P_pokemon1.equals(P_pokemon2)) {
        	 P_pokemon2 = getRandomPokemon(plist2);
         }
  
         // Ensure that Opp_pokemon1 is different from P_pokemon1 and P_pokemon2
         do {
        	 Opp_pokemon1 = getRandomPokemon(plist1);
         } while (Opp_pokemon1.equals(P_pokemon1) || Opp_pokemon1.equals(P_pokemon2));

         do {
        	 Opp_pokemon2 = getRandomPokemon(plist2);
         } while (Opp_pokemon2.equals(Opp_pokemon1) || Opp_pokemon2.equals(P_pokemon1) || Opp_pokemon2.equals(P_pokemon2));
  
        System.out.println("The Pokémon around you heard your roar!\n");
        System.out.println("\n\nCongratulations! You've caught a " + P_pokemon1 + " and " + P_pokemon2 + ".\n");
        System.out.println("Your opponent caught a " + Opp_pokemon1 + " and " + Opp_pokemon2 + ".\n");
        
        displayPokemonDetails("Your first Pokemon (P_pokemon1)", P_pokemon1);
        displayPokemonDetails("Your second Pokemon (P_pokemon2)", P_pokemon2);
        displayPokemonDetails("Your first Opponent Pokemon (Opp_pokemon1)", Opp_pokemon1);
        displayPokemonDetails("Your second Opponent Pokemon (Opp_pokemon2)", Opp_pokemon2);
        
        startBattle();
    }

    private List<Pokemon> getRandomPokemonList(List<String> plist) {
        Collections.shuffle(plist);
        List<Pokemon> chosenPokemon = new ArrayList<>();

        for (int i = 0; i < 3 && i < plist.size(); i++) {
            Pokemon pokemon = findPokemonByName(plist.get(i));
            chosenPokemon.add(pokemon);

            System.out.println("Pokemon " + (i + 1) + ":");
            System.out.println("Name: " + pokemon.getName());
            System.out.println("Grade: " + pokemon.getGrade());
            System.out.println("HP: " + pokemon.getHp());
            System.out.println("Poke Energy: " + pokemon.getPoke_ene());
            System.out.println("Attack Power: " + pokemon.getAttackPower());
            System.out.println("Defence Power: " + pokemon.getDefencePower());
            System.out.println();
        }

        return chosenPokemon;
    }
    
    public void displayPokemonDetails(String title, String pokemonName) {
        Pokemon pokemon = findPokemonByName(pokemonName);
        System.out.println(title + ":");
        System.out.println("Name: " + pokemon.getName());
        System.out.println("Grade: " + pokemon.getGrade());
        System.out.println("HP: " + pokemon.getHp());
        System.out.println("Poke Energy: " + pokemon.getPoke_ene());
        System.out.println("Type: " + pokemon.getAttackType());
        System.out.println("Attack Power: " + pokemon.getAttackPower());
        System.out.println("Defence Power: " + pokemon.getDefencePower());
        System.out.println();
    }

    
    public String getRandomPokemon(List<String> plist) {
        Random random = new Random();
        int randomIndex = random.nextInt(plist.size());
        return plist.get(randomIndex);
      }

      // Helper method to find a Pokemon by name in the existing lists
      public Pokemon findPokemonByName(String name) {
        for (Pokemon pokemon : plist1) {
          if (pokemon.getName().equals(name)) {
            return pokemon;
          }
        }

        for (Pokemon pokemon : plist2) {
          if (pokemon.getName().equals(name)) {
            return pokemon;
          }
        }
        // Handle the case where the Pokemon is not found (return a default Pokemon)
        return new Pokemon("Default", 1);
      }

      public void attackTurn(int totalPresses) {

        Pokemon pokemon1 = findPokemonByName(P_pokemon1);
        Pokemon pokemon2 = findPokemonByName(P_pokemon2);
        Pokemon oppPokemon1 = findPokemonByName(Opp_pokemon1);
        Pokemon oppPokemon2 = findPokemonByName(Opp_pokemon2);

        if (totalPresses > 20) {
          System.out.println("Your ally's attack!\n");
//          System.out.println(P_pokemon1);

          effectiveness1 = calculateMoveEffectiveness(pokemon1, oppPokemon1);
          effectiveness2 = calculateMoveEffectiveness(pokemon1, oppPokemon2);
          effectiveness3 = calculateMoveEffectiveness(pokemon2, oppPokemon1);
          effectiveness4 = calculateMoveEffectiveness(pokemon2, oppPokemon2);
          
          System.out.println(pokemon1.getName() + " is attacking " + oppPokemon1.getName() + "!");
          pokemon1.attack(oppPokemon1, effectiveness1);
          
          System.out.println("\n" + pokemon1.getName() + " is attacking " + oppPokemon2.getName() + "!");
          pokemon1.attack(oppPokemon2, effectiveness2);
          
          System.out.println("\n" +pokemon2.getName() + " is attacking " + oppPokemon1.getName() + "!");
          pokemon2.attack(oppPokemon1, effectiveness3);
          
          System.out.println("\n" +pokemon1.getName() + " is attacking " + oppPokemon2.getName() + "!");
          pokemon2.attack(oppPokemon2, effectiveness4);
          if ((!(pokemon1.isDefeated(oppPokemon1)))|| (!(pokemon1.isDefeated(oppPokemon2))) || 
          		(!(pokemon2.isDefeated(oppPokemon1))) || (!(pokemon2.isDefeated(oppPokemon2)))) {

            System.out.println("\nOne more round !!!\n");
            looping();
          }
          else {
        	System.out.println("\n" + oppPokemon1.getName() + " and " + oppPokemon2.getName() + " are defeated...");
        	System.out.println("Your team Pokemon WIN !!!\n");
            throwBall();
            calculateScore(pokemon1, pokemon2, turnCount);
            extraBattle();
          }

        } 
        else {
      	  System.out.println("Defend your Pokémon!\n");
            effectiveness1 = calculateMoveEffectiveness(oppPokemon1, pokemon1);
            effectiveness2 = calculateMoveEffectiveness(oppPokemon1, pokemon2);        
            effectiveness3 = calculateMoveEffectiveness(oppPokemon2, pokemon1);
            effectiveness4 = calculateMoveEffectiveness(oppPokemon2, pokemon2);
            
            System.out.println("\n" + oppPokemon1.getName() + " is attacking " + pokemon1.getName() + "!");
            oppPokemon1.attack(pokemon1, effectiveness1);
            
            System.out.println("\n" +oppPokemon1.getName() + " is attacking " + pokemon2.getName() + "!");
            oppPokemon1.attack(pokemon2, effectiveness2);
            
            System.out.println("\n" +oppPokemon2.getName() + " is attacking " + pokemon1.getName() + "!");
            oppPokemon2.attack(pokemon1, effectiveness3);
            
            System.out.println("\n" +oppPokemon2.getName() + " is attacking " + pokemon2.getName() + "!");
            oppPokemon2.attack(pokemon2, effectiveness4);

            if ((!(oppPokemon1.isDefeated(pokemon1))) || (!(oppPokemon1.isDefeated(pokemon2))) || 
            		(!(oppPokemon2.isDefeated(pokemon1))) || (!(oppPokemon2.isDefeated(pokemon2)))) {
              System.out.println("\nOne more round !!!\n");
              looping();
            }
          else {
        	System.out.println("\nYour team, " + pokemon1.getName() + " and " + pokemon2.getName() + " are defeated...");
        	System.out.println("Learn from this, victory awaits!\n");
            calculateLoseScore(pokemon1, pokemon2, turnCount);
            endBattle();
          }
        }
      }

      public double extraBattle() {
    	  continue_game.continue_button();
        turnCount = 0;
          if (!extraBattleFlag) {
              extraBattleFlag = true;  // Set the flag to indicate an extra battle has been initiated
              System.out.println("\nPress the button to win a chance for an extra battle!\n");
              System.out.println();
              
              int totalPresses1 = buttonTurn.handleKeyInput();
              if (totalPresses1 > 25) {
            	  System.out.println("Yay, you got an Extra Battle chance!");
              	  continue_game.continue_button();
                  System.out.println("\nROAR and call your Pokémon!\nCharge your spirit by smashing on the buttons!");
                  int totalPresses2 = buttonTurn.handleKeyInput();
                  determinePokemon(totalPresses2);
                  extraBattleFlag = false;
                  endBattle();
              } else {
            	  System.out.println("Oh no.. you just missed an Extra Battle chance");
            	  endBattle();
              }
          }
          return effectiveness1;
      }

      public double calculateMoveEffectiveness(Pokemon attacker, Pokemon defender) {
        MoveEffectiveness.PokemonType attackerType = MoveEffectiveness.PokemonType.valueOf(attacker.getAttackType());
        MoveEffectiveness.PokemonType defenderType = MoveEffectiveness.PokemonType.valueOf(defender.getAttackType());

        double effectiveness = MoveEffectiveness.getMoveEffectiveness(attackerType, defenderType);

        System.out.println(attacker.getName() + "'s attack type is " + attacker.getAttackType());
        System.out.println(defender.getName() + "'s attack type is " + defender.getAttackType());
        System.out.println("Move effectiveness: " + effectiveness + " (" + attacker.getName() + " to " + defender.getName() + ")" + "\n");

        return effectiveness;
      }

      public void calculateScore(Pokemon p1, Pokemon p2, int turnCount) {
        // Constants for maximum values
        final int MAX_ATTACK_POWER = 100;

        // Retrieve attributes from the Pokemon class
        int p1grade = p1.getGrade();
        int p1energy = p1.getPoke_ene();
        int p1attackPower = p1.getAttackPower();
        int p1hp = p1.getHp();
        
        int p2grade = p2.getGrade();
        int p2energy = p2.getPoke_ene();
        int p2attackPower = p2.getAttackPower();
        int p2hp = p2.getHp();

        double p1hpContribution = ((double) p1energy / p1hp) * 300;
        double p1attackPowerContribution = ((double) p1attackPower / MAX_ATTACK_POWER) * 300;
        double p1gradeContribution = ((double) p1grade / 5) * 100;
        
        double p2hpContribution = ((double) p2energy / p2hp) * 300;
        double p2attackPowerContribution = ((double) p2attackPower / MAX_ATTACK_POWER) * 300;
        double p2gradeContribution = ((double) p2grade / 5) * 100;
        
        double p1score = p1hpContribution + p1attackPowerContribution + p1gradeContribution;
        double p2score = p2hpContribution + p2attackPowerContribution + p2gradeContribution;

        // Total score
        double totalScore = p1score + p2score;

        // Ensure the score is not in decimal value and in the below the MAX_SCORE
        int finalScore = (int) totalScore;
        
        System.out.println("\n\nScore that you received for this battle: " + finalScore);
        player.setScore(finalScore);
        player.getScore();
      }
      
      public void calculateLoseScore(Pokemon p1, Pokemon p2, int turnCount) {
          // Constants for maximum values
          final int MAX_ATTACK_POWER = 100;

          // Retrieve attributes from the Pokemon class
          int p1grade = p1.getGrade();
          int p1energy = p1.getPoke_ene();
          int p1attackPower = p1.getAttackPower();
          int p1hp = p1.getHp();
          
          int p2grade = p2.getGrade();
          int p2energy = p2.getPoke_ene();
          int p2attackPower = p2.getAttackPower();
          int p2hp = p2.getHp();

          double p1hpContribution = ((double) p1energy /10);
          double p1attackPowerContribution = ((double) p1attackPower / MAX_ATTACK_POWER) * 250;
          double p1gradeContribution = ((double) p1grade / 5) * 350;
          
          double p2hpContribution = ((double) p2energy /10);
          double p2attackPowerContribution = ((double) p2attackPower / MAX_ATTACK_POWER) * 250;
          double p2gradeContribution = ((double) p2grade / 5) * 350;
          
          double p1score = p1hpContribution + p1attackPowerContribution + p1gradeContribution;
          double p2score = p2hpContribution + p2attackPowerContribution + p2gradeContribution;

          // Total score
          double totalScore = p1score + p2score;

          // Ensure the score is not in decimal value and in the below the MAX_SCORE
          int finalScore = (int) totalScore;
          
          System.out.println("\n\nScore that you received for this battle: " + finalScore);
          
          player.setScore(finalScore);
          player.getScore();
        }

      // generate random ball 
      public void throwBall() {
          Pokemon oppPokemon1 = findPokemonByName(Opp_pokemon1);
          Pokemon oppPokemon2 = findPokemonByName(Opp_pokemon2);
   
          System.out.println("\nIt's time to throw the Ball and discover which amazing Pokémon awaits on the other side!\n");
          Random randnum = new Random();
          int number = 1 + randnum.nextInt(4);

          Ball ball1;
          Ball ball2;

          switch (number) {
              case 1:
                  System.out.println("Congratulations, a Pokeball is thrown!");
                  ball1 = new Pokeball(oppPokemon1);
                  ball2 = new Pokeball(oppPokemon2);
                  break;
              case 2:
                  System.out.println("Congratulations, a Greatball is thrown!");
                  ball1 = new Greatball(oppPokemon1);
                  ball2 = new Greatball(oppPokemon2);
                  break;
              case 3:
                  System.out.println("Congratulations, an Ultraball is thrown!");
                  ball1 = new Ultraball(oppPokemon1);
                  ball2 = new Ultraball(oppPokemon2);
                  break;
              case 4:
                  System.out.println("Congratulations, a Masterball is thrown!");
                  ball1 = new Masterball(oppPokemon1);
                  ball2 = new Masterball(oppPokemon2);
                  break;
              default:
                  ball1 = new Pokeball(oppPokemon1);
                  ball2 = new Pokeball(oppPokemon2);
                  break;
          }
          // Call the canCatchPokemon method
          canCatchPokemon(oppPokemon1, ball1);
          canCatchPokemon(oppPokemon2, ball2);
          
      }

      public void canCatchPokemon(Pokemon pokemon, Ball ball) {
        ball.canCatchPokemon(pokemon);
      }

      public void endBattle() {
          Scanner input = new Scanner(System.in);
          int option;

          System.out.println("\n\nWell Done! Let's go back to Pokémon Centre.");
          game.repeatGame();
      }

      // toString

    }