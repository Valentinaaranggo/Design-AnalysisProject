package main;

import java.util.Arrays;
//import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate synthetic data for a complete graph
        int numLocations = 3;
        generateData(numLocations);

    }

    private static int[][] generateData(int numLocations) {
        int[][] syntheticGraph = new int[numLocations][numLocations];
        Random random = new Random();

        for (int i = 0; i < numLocations; i++) {
            for (int j = 0; j < numLocations; j++) {
                if (i != j) {
                    syntheticGraph[i][j] = random.nextInt(10) + 1; // Random weight between 1 and 10
                } else {
                    syntheticGraph[i][j] = 0;
                }
            }
        }
        System.out.println("Synthetic Graph Matrix:");
        for (int[] row : syntheticGraph) {
            System.out.println(Arrays.toString(row));
        }

        return syntheticGraph;
    }

}
