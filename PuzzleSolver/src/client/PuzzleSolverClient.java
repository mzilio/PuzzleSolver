package client;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;

public class PuzzleSolverClient {
    public static void main(String[] args) throws Exception {
        String inputFile = new String(), outputFile = new String();
        try {
            inputFile = args[0];
            outputFile = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Non sono stati forniti i nomi dei file di I/O (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
        IPuzzle puzzle = (IPuzzle) Naming.lookup(args[2]);
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);
        Reader read = new Reader(puzzle, inputPath);
        try {
            puzzle.solve(read.getFirst());
        } catch (InterruptedException e) {
            System.err.println("Problemi con i thread (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
        Writer write = new Writer(puzzle, outputPath);
    }
}