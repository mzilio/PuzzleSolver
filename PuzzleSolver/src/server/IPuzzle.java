package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPuzzle extends Remote {
    public boolean addPiece(Piece x) throws RemoteException;
    public void solve(Piece first) throws InterruptedException, RemoteException;
    public String getSolution() throws RemoteException;
    public String getSingleRow(int pos) throws RemoteException;
    public int numberOfRow() throws RemoteException;
    public int numberOfCol() throws RemoteException;
}