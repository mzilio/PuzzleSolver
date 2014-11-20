package parte1;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Reader {
    private final Puzzle puzzle;
    private static final Charset charset = StandardCharsets.UTF_8;
    Reader(Puzzle p, Path inputPath) {
        puzzle = p;
        readFile(inputPath);
    }
    public final void readFile(Path inputPath) {
        try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public void parseLine(String line) {
        String[] values = line.split("\t",6);
        Piece x = new Piece(values[0],values[1].charAt(0),values[2],values[3],values[4],values[5]);
        puzzle.addPiece(x);
    }
}