package main;

public class Edge {
    Node sourcNode;
    Node destinNode;
    int weight;

    Edge(Node sourcNode, Node destinNode, int weight) {
        this.sourcNode = sourcNode;
        this.destinNode = destinNode;
        this.weight = weight;
    }
}
