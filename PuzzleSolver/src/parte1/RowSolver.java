package parte1;

public class RowSolver extends Thread {
    private final Puzzle puzzle;
    private final Piece first;
    private final int position;
    RowSolver(Puzzle x, Piece y, int pos) {
        puzzle = x;
        first = y;
        position = pos;
    }
    @Override
    public void run() {
        String row = new String();
        row = row + first.getData();
        String nextRowId = first.getIdE();
        while(nextRowId.compareTo("VUOTO")!=0) {
            Piece next = new Piece(nextRowId);
            Piece nextPiece = puzzle.find(next);
            row = row + nextPiece.getData();
            nextRowId = nextPiece.getIdE();
        }
        synchronized(puzzle) {
            puzzle.addRowSolved(position, row);
            puzzle.newRowSolved();
            if(puzzle.isSolved())
                puzzle.notify();
        }
    }
}