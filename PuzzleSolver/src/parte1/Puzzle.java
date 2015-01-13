package parte1;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Puzzle {
    private final TreeSet<Piece> pieces;
    private final List<Piece> solution;
    private int rowNum;
    private int rowSolved;
    Puzzle() {
        pieces = new TreeSet<>();
        solution = new ArrayList<>();
        rowNum = 0;
    }
    public boolean addPiece(Piece x) {
        return pieces.add(x);
    }
    public Piece find(Piece x) {
        return pieces.floor(x);
    }
    public int size(){
        return pieces.size();
    }
    public int numberOfRow() {
        return rowNum;
    }
    public int numberOfCol() {
        return size()/rowNum;
    }
    public boolean isSolved() {
        return (rowNum-rowSolved) == 0;
    }
    public void newRowSolved() {
        rowSolved++;
    }
    public List<Piece> getSolution() {
        return solution;
    }
    public void addRowSolved(List<Piece> row) {
        solution.addAll(row);
    }
    public void solve(Piece first) throws InterruptedException {
        RowSolver r = new RowSolver(this, first);
        r.start();
        rowNum++;
        String nextColId = first.getIdS();
        while(nextColId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextColId);
            Piece nextRow = pieces.floor(next);
            r = new RowSolver(this, nextRow);
            r.start();
            rowNum++;
            nextColId = nextRow.getIdS();
        }
        synchronized(this) {
            while(!isSolved())
                wait();
        }
    }
}