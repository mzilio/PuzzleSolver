package parte1;

import java.util.TreeSet;

public class Puzzle {
    private final TreeSet<Piece> pieces;
    Puzzle() {
        pieces = new TreeSet();
    }
    public boolean addPiece(Piece x) {
        return pieces.add(x);
    }
    public int size(){
        return pieces.size();
    }
}