package Model;

public class MonomInteger extends Monom{
    private int coef;

    public MonomInteger(int putere, int coef) {
        super(putere);
        this.coef = coef;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }
}
