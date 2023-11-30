package main;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        generateMultipleGraphs(3);

    }

    public static int[][] generateData(int numLocations) {
        int[][] syntheticGraph = new int[numLocations][numLocations];
        Random random = new Random();

        for (int i = 0; i < numLocations; i++) {
            for (int j = 0; j < numLocations; j++) {
                int weight = random.nextInt(10) + 1;
                if (i == j) {
                    syntheticGraph[i][j] = 0;
                } else {
                    syntheticGraph[i][j] = weight;
                    syntheticGraph[j][i] = weight;
                }
            }
        }

        System.out.println("Synthetic Graph Matrix:");
        for (int[] row : syntheticGraph) {
            System.out.println(Arrays.toString(row));
        }

        return syntheticGraph;
    }

    public static void generateMultipleGraphs(int numGraphs) {

        for (int i = 1; i <= numGraphs; i++) {
            Random random = new Random();
            int numLocations = random.nextInt(4) + 3;
            generateData(numLocations);
        }

    }

}
