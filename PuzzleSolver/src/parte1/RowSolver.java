package parte1;

import java.util.ArrayList;
import java.util.List;

public class RowSolver extends Thread {
    private final Puzzle puzzle;
    private final Piece first;
    RowSolver(Puzzle x, Piece y) {
        puzzle = x;
        first = y;
    }
    @Override
    public void run() {
        List<Piece> row = new ArrayList<>();
        row.add(first);
        String nextRowId = first.getIdE();
        while(nextRowId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextRowId);
            Piece nextPiece = puzzle.find(next);
            row.add(nextPiece);
            nextRowId = nextPiece.getIdE();
        }
        try{
            Thread.sleep(50);
        }catch(InterruptedException e){
            System.out.println("Thread interrotto!");
        }
        synchronized(puzzle) {
            puzzle.addRowSolved(row);
            puzzle.newRowSolved();
            if(puzzle.isSolved())
                puzzle.notify();
        }
    }
}