package parte1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PuzzleSolver {
    public static void main(String[] args) {
        String inputFile = null, outputFile = null;
        try {
            inputFile = args[0];
            outputFile = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Non sono stati forniti i nomi dei file di I/O (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
        Puzzle puzzle = new Puzzle();
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);
        Reader read = new Reader(puzzle, inputPath);
        try {
            puzzle.solve(read.getFirst());
        } catch (InterruptedException e) {
            
        }
        Writer write = new Writer(puzzle, outputPath);
    }
}