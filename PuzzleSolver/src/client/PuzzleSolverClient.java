package client;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PuzzleSolverClient {
    public static void main(String[] args) {
        String inputFile = new String(), outputFile = new String();
        try {
            inputFile = args[0];
            outputFile = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Non sono stati forniti i nomi dei file di I/O");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
        try {
            IPuzzle puzzle = (IPuzzle) Naming.lookup(args[2]);
            Path inputPath = Paths.get(inputFile);
            Path outputPath = Paths.get(outputFile);
            Reader read = new Reader(puzzle, inputPath);
            try {
                puzzle.solve(read.getFirst());
            } catch (InterruptedException e) {
                System.err.println("Problemi con i thread");
                System.err.println("Il programma verrà terminato!");
                System.exit(1);
            }
            Writer write = new Writer(puzzle, outputPath);
        } catch(NotBoundException | MalformedURLException | RemoteException e) {
            System.err.println("Problemi con la connessione al server");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
}