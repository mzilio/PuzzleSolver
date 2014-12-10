package parte1;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Reader {
    private final Puzzle puzzle;
    private Piece first;
    private static final Charset charset = StandardCharsets.UTF_8;
    Reader(Puzzle p, Path inputPath) {
        puzzle = p;
        readFile(inputPath);
    }
    private void readFile(Path inputPath) {
        try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            System.err.println("Problemi con la lettura del file di input (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Il file di input non è formattato correttamente (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
    private void parseLine(String line) {
        String[] values = line.split("\t",6);
        for(String value : values) {
            value = value.trim();
        }
        Piece x = new Piece(values[0],values[1].charAt(0),values[2],values[3],values[4],values[5]);
        if(values[2].compareTo("VUOTO")==0 && values[5].compareTo("VUOTO")==0) {
            first = x;
        }
        puzzle.addPiece(x);
    }
    public Piece getFirst() {
        return first;
    }
}