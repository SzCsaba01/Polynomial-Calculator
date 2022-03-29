package Model;

import java.util.ArrayList;
import java.util.List;

public class Polynom {
    private List<Monom> monoame;

    public Polynom() {
        this.monoame = new ArrayList<>();
    }

    public void addMonom(Monom monom){
        monoame.add(monom);
    }

    public List<Monom> getMonoame() {
        return monoame;
    }

    public void setMonoame(List<Monom> monoame) {
        this.monoame = monoame;
    }
}
