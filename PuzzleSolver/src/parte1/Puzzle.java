package parte1;

import java.util.TreeSet;
import java.util.LinkedList;

public class Puzzle {
    private final TreeSet<Piece> pieces;
    private final LinkedList<Piece> solution;
    private int rowNum;
    private boolean solved;
    //private int colNum;
    Puzzle() {
        pieces = new TreeSet();
        solution = new LinkedList();
        rowNum = 0;
        solved = false;
        //colNum = 0;
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
    public LinkedList<Piece> getSolution() {
        return solution;
    }
    public void solve(Piece first) {
        solution.addAll(solveRow(first));
        rowNum++;
        String nextColId = first.getIdS();
        while(!nextColId.isEmpty()) {
            Piece next = new Piece(nextColId);
            Piece nextRow = pieces.floor(next);
            solution.addAll(solveRow(nextRow));
            rowNum++;
            nextColId = nextRow.getIdS();
        }
        solved = true;
    }
    public LinkedList<Piece> solveRow(Piece first) {
        LinkedList<Piece> row = new LinkedList();
        row.add(first);
        //colNum++;
        String nextRowId = first.getIdE();
        while(!nextRowId.isEmpty()) {
            Piece next = new Piece(nextRowId);
            Piece nextPiece = pieces.floor(next);
            row.add(nextPiece);
            //colNum++;
            nextRowId = nextPiece.getIdE();
        }
        return row;
    }
}