package client;

import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;

public class Writer {
    private final IPuzzle puzzle;
    private static final Charset charset = StandardCharsets.UTF_8;
    Writer(IPuzzle p, Path outputPath) throws RemoteException {
        puzzle = p;
        writeFile(outputPath);
    }
    private void writeFile(Path outputPath) throws RemoteException {
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
            if(e instanceof RemoteException)
                throw new RemoteException();
            System.err.println("Problemi con la scrittura del file di output (" + e + ")");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
}