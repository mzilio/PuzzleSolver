package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class PuzzleSolverServer {
    public static void main(String[] args) {
        try {
            Puzzle puzzle = new Puzzle();
            Naming.rebind(args[0],puzzle);
        } catch(RemoteException e) {
            System.err.println("Problemi con il registro RMI");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        } catch(MalformedURLException e) {
            System.err.println("Il nome del server non è propriamente formattato");
            System.err.println("Il programma verrà terminato!");
            System.exit(1);
        }
    }
}