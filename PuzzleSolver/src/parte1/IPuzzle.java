package parte1;

import java.rmi.Remote;

public interface IPuzzle extends Remote {
    public boolean addPiece(Piece x);
    public void solve(Piece first) throws InterruptedException ;
    public String getSolution();
    public String getSingleRow(int pos);
    public int numberOfRow();
    public int numberOfCol();
}