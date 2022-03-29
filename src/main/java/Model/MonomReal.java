package Model;

public class MonomReal extends Monom{
    private float coef;

    public MonomReal(int putere, float coef) {
        super(putere);
        this.coef = coef;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }
}
