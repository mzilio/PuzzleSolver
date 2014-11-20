package parte1;

import java.util.Set;
import java.util.TreeSet;

public class Puzzle {
    private final Set<Piece> pieces;
    Puzzle() {
        pieces = new TreeSet();
    }
    public boolean addPiece(Piece x) {
        return pieces.add(x);
    }
}