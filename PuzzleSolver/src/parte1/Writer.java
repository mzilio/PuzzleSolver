package parte1;

import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Iterator;

public class Writer {
    private final Puzzle puzzle;
    private static final Charset charset = StandardCharsets.UTF_8;
    Writer(Puzzle p, Path outputPath) {
        puzzle = p;
        writeFile(outputPath);
    }
    private void writeFile(Path outputPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, charset)) {
            if(puzzle.isSolved()) {
                List<Piece> list = puzzle.getSolution();
                Iterator<Piece> it = list.iterator();
                while(it.hasNext()) {
                    writer.write(it.next().getData());
                }
                writer.newLine();
                writer.newLine();
                it = list.iterator();
                int colNum = puzzle.numberOfCol();
                int colCount = 0;
                while(it.hasNext()) {
                    writer.write(it.next().getData());
                    colCount++;
                    if(colCount == colNum) {
                        writer.newLine();
                        colCount = 0;
                    }
                }
                writer.newLine();
                writer.write(puzzle.numberOfRow() + " " + puzzle.numberOfCol());
            }
        }
        catch (IOException e) {
            System.err.println("Problemi con la scrittura del file di output (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
}