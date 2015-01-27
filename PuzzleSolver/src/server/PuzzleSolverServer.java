package server;

import java.rmi.Naming;

public class PuzzleSolverServer {
    public static void main(String[] args) throws Exception {
        Puzzle puzzle = new Puzzle();
        Naming.rebind(args[0],puzzle);
    }
}