package parte1;

import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.LinkedList;

public class PuzzleSolver {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        String inputFile = args[0];
        String outputFile = args[1];
        
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);
        
        Reader read = new Reader(puzzle, inputPath);
        puzzle.solve(read.getFirst());
        Writer write = new Writer(puzzle, outputPath);
    }
}