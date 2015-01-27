package client;

import java.io.Serializable;

public class Piece implements Comparable<Piece>, Serializable {
    private final String id;
    private final char data;
    private final String id_n;
    private final String id_e;
    private final String id_s;
    private final String id_w;
    Piece(String i, char c, String n, String e, String s, String w) {
        id = i;
        data = c;
        id_n = n;
        id_e = e;
        id_s = s;
        id_w = w;
    }
    Piece(String i) {
        id = i;
        data = '\0';
        id_n = null;
        id_e = null;
        id_s = null;
        id_w = null;
    }
    public String getId() {
        return id;
    }
    public char getData() {
        return data;
    }
    public String getIdN() {
        return id_n;
    }
    public String getIdE() {
        return id_e;
    }
    public String getIdS() {
        return id_s;
    }
    public String getIdW() {
        return id_w;
    }
    @Override
    public int compareTo(Piece x) {
        return id.compareTo(x.getId());
    }
}