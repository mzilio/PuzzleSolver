package parte1;

import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Puzzle extends UnicastRemoteObject implements IPuzzle {
    private final TreeSet<Piece> pieces;
    private final Map<Integer, String> solution;
    private int rowNum;
    private int rowSolved;
    Puzzle() throws RemoteException {
        pieces = new TreeSet<>();
        solution = new HashMap<>();
        rowNum = 0;
    }
    @Override
    public boolean addPiece(Piece x) {
        return pieces.add(x);
    }
    public Piece find(Piece x) {
        return pieces.floor(x);
    }
    public int size(){
        return pieces.size();
    }
    @Override
    public int numberOfRow() {
        return rowNum;
    }
    @Override
    public int numberOfCol() {
        return size()/rowNum;
    }
    public boolean isSolved() {
        return (rowNum-rowSolved) == 0;
    }
    public void newRowSolved() {
        rowSolved++;
    }
    public void addRowSolved(int pos, String row) {
        solution.put(pos, row);
    }
    @Override
    public String getSolution() {
        String sol = new String();
        for(int i=0; i<rowNum; i++) {
            sol = sol + solution.get(i);
        }
        return sol;
    }
    @Override
    public String getSingleRow(int pos) {
        String sol = new String();
        sol = sol + solution.get(pos);
        return sol;
    }
    @Override
    public void solve(Piece first) throws InterruptedException {
        new RowSolver(this, first, rowNum).start();
        rowNum++;
        String nextColId = first.getIdS();
        while(nextColId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextColId);
            Piece nextRow = pieces.floor(next);
            new RowSolver(this, nextRow, rowNum).start();
            rowNum++;
            nextColId = nextRow.getIdS();
        }
        synchronized(this) {
            while(!isSolved())
                wait();
        }
    }
}