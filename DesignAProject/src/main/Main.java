package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        generateMultipleGraphs(3);

    }

    // generatesdata for an adjacency matrix
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
        matrixToGraph(syntheticGraph);
        return syntheticGraph;
    }

    // generates multiple graphs/matrices
    public static void generateMultipleGraphs(int numGraphs) {

        for (int i = 1; i <= numGraphs; i++) {
            Random random = new Random();
            int numLocations = random.nextInt(4) + 3;
            generateData(numLocations);
        }

    }

    // converts a matrix into a graph
    public static void matrixToGraph(int[][] matrix) {
        List<Node> nodes = new ArrayList<>();
        Set<Edge> visitedEdges = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    Edge edge = new Edge(nodes.get(i), nodes.get(j), matrix[i][j]);
                    visitedEdges.add(edge);
                }
            }
        }

        System.out.println("Graph Representation:");
        for (Edge edge : visitedEdges) {
            System.out.println("Edge: " + edge.sourcNode.n + "----" + edge.destinNode.n + ", Weight: " + edge.weight);
        }
    }
}
