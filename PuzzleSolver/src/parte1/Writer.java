package parte1;

import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Writer {
    private final Puzzle puzzle;
    private static final Charset charset = StandardCharsets.UTF_8;
    Writer(Puzzle p, Path outputPath) {
        puzzle = p;
        writeFile(outputPath);
    }
    private void writeFile(Path outputPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, charset)) {
            writer.write(puzzle.getSolution());
            writer.newLine();
            writer.newLine();
            for(int i=0; i<puzzle.numberOfRow(); i++) {
                writer.write(puzzle.getSingleRow(i));
                writer.newLine();
            }
            writer.newLine();
            writer.write(puzzle.numberOfRow() + " " + puzzle.numberOfCol());
        }
        catch (IOException e) {
            System.err.println("Problemi con la scrittura del file di output (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
}