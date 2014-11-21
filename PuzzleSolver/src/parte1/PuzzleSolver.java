package parte1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PuzzleSolver {
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        String inputFile = args[0];
        //String outputFile = args[1];
        
        Path inputPath = Paths.get(inputFile);
        //Path outputPath = Paths.get(outputFile);
        
        Reader read = new Reader(puzzle, inputPath);
        System.out.println(puzzle.size());
        System.out.println(read.getFirst().getData());
    }
}