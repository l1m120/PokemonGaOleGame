import java.io.*;

public class MoveEffectiveness {

	// attributes
	
	// constructor
	
	// setter getter
	
	// other methods
    public enum PokemonType {
        FIRE, WATER, ELECTRIC, STEEL, GROUND
    }

    public static double[][] moveEffectiveness = {
            //          FIRE, WATER, ELECTRIC, STEEL, GROUND
            /* FIRE     */ {1.0, 0.5, 1.0, 2.0, 1.0},
            /* WATER    */ {2.0, 1.0, 1.0, 0.5, 1.0},
            /* ELECTRIC */ {1.0, 2.0, 0.5, 1.0, 2.0},
            /* STEEL    */ {0.5, 1.0, 1.0, 0.5, 2.0},
            /* GROUND   */ {1.0, 1.0, 2.0, 2.0, 1.0},
    };

    public static double getMoveEffectiveness(PokemonType attackerType, PokemonType defenderType) {
        int attackerIndex = attackerType.ordinal();
        int defenderIndex = defenderType.ordinal();
        return moveEffectiveness[attackerIndex][defenderIndex];
    }

    public static void printEffectivenessChart() {
        System.out.println("Move Effectiveness Chart:");

        for (PokemonType attackerType : PokemonType.values()) {
            System.out.print(attackerType + ": ");
            for (PokemonType defenderType : PokemonType.values()) {
                double effectiveness = getMoveEffectiveness(attackerType, defenderType);
                System.out.printf("%.2f\t", effectiveness);
            }
            System.out.println();
        }
    }

    public static void saveEffectivenessData(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (double[] row : moveEffectiveness) {
                for (double value : row) {
                    writer.print(value + "\t");
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}