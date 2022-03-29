package Model;

public class Monom implements Comparable<Monom> {
    private int putere;

    public Monom(int putere) {
        this.putere = putere;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    @Override
    public int compareTo(Monom o) {
        if(putere > o.getPutere())
            return -1;
        if(putere < o.getPutere())
            return 1;
        return 0;
    }
}
