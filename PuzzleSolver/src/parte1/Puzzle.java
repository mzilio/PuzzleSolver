package parte1;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Puzzle {
    private final TreeSet<Piece> pieces;
    private final List<Piece> solution;
    private int rowNum;
    private boolean solved;
    Puzzle() {
        pieces = new TreeSet<>();
        solution = new ArrayList<>();
        rowNum = 0;
        solved = false;
    }
    public boolean addPiece(Piece x) {
        return pieces.add(x);
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
        return solved;
    }
    public List<Piece> getSolution() {
        return solution;
    }
    public void solve(Piece first) {
        solution.addAll(solveRow(first));
        rowNum++;
        String nextColId = first.getIdS();
        while(nextColId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextColId);
            Piece nextRow = pieces.floor(next);
            solution.addAll(solveRow(nextRow));
            rowNum++;
            nextColId = nextRow.getIdS();
        }
        solved = true;
    }
    private List<Piece> solveRow(Piece first) {
        List<Piece> row = new ArrayList<>();
        row.add(first);
        String nextRowId = first.getIdE();
        while(nextRowId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextRowId);
            Piece nextPiece = pieces.floor(next);
            row.add(nextPiece);
            nextRowId = nextPiece.getIdE();
        }
        return row;
    }
}