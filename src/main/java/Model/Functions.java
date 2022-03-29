package Model;

public class Functions {

    public static Polynom AddPolynoms(Polynom polynom1, Polynom polynom2){
        Polynom result = new Polynom();
        int coefInt1 = 0;
        int coefInt2 = 0;
        int i = 0;
        int j = 0;
        int sizePolynom1 = polynom1.getMonoame().size();
        int sizePolynom2 = polynom2.getMonoame().size();
        while ( i < sizePolynom1 && j < sizePolynom2){
            if(polynom1.getMonoame().get(i).getPutere() == polynom2.getMonoame().get(j).getPutere()){
                coefInt1 = ((MonomInteger) polynom1.getMonoame().get(i)).getCoef();
                coefInt2 = ((MonomInteger) polynom2.getMonoame().get(j)).getCoef();
                result.addMonom(new MonomInteger(polynom1.getMonoame().get(i).getPutere(), coefInt1 + coefInt2));
               i++;
               j++;
               if(i == sizePolynom1 || j == sizePolynom2)
                   break;
            }
            if(polynom1.getMonoame().get(i).getPutere() > polynom2.getMonoame().get(j).getPutere()){
                result.addMonom(polynom1.getMonoame().get(i));
                i++;
                if(i == sizePolynom1)
                    break;
            }
            if(polynom2.getMonoame().get(j).getPutere() > polynom1.getMonoame().get(i).getPutere()){
                result.addMonom(polynom2.getMonoame().get(j));
                j++;
                if(j == sizePolynom2)
                    break;
            }
        }
        while(i < sizePolynom1){
            result.addMonom(polynom1.getMonoame().get(i));
            i++;
        }
        while(j < sizePolynom2){
            result.addMonom(polynom2.getMonoame().get(j));
            j++;
        }
        return result;
    }

    public static Polynom SubtractPolynoms(Polynom polynom1, Polynom polynom2){
        Polynom result = new Polynom();
        float coefReal1 = 0;
        float coefReal2 = 0;
        int coefInt1 = 0;
        int coefInt2 = 0;
        int i = 0;
        int j = 0;
        int sizePolynom1 = polynom1.getMonoame().size();
        int sizePolynom2 = polynom2.getMonoame().size();
        while ( i < sizePolynom1 && j < sizePolynom2) {
            if (polynom1.getMonoame().get(i).getPutere() == polynom2.getMonoame().get(j).getPutere()) {
                if (polynom1.getMonoame().get(i) instanceof MonomReal) {
                    coefReal1 = ((MonomReal) polynom1.getMonoame().get(i)).getCoef();
                    if (polynom2.getMonoame().get(j) instanceof MonomReal) {
                        coefReal2 = ((MonomReal) polynom2.getMonoame().get(j)).getCoef();
                        result.addMonom(new MonomReal(polynom1.getMonoame().get(i).getPutere(), coefReal1 - coefReal2));
                    } else {
                        coefInt2 = ((MonomInteger) polynom2.getMonoame().get(j)).getCoef();
                        result.addMonom(new MonomReal(polynom1.getMonoame().get(i).getPutere(), coefReal1 - coefInt2));
                    }
                } else {
                    coefInt1 = ((MonomInteger) polynom1.getMonoame().get(i)).getCoef();

                    if (polynom2.getMonoame().get(j) instanceof MonomReal) {
                        coefReal2 = ((MonomReal) polynom2.getMonoame().get(j)).getCoef();
                        result.addMonom(new MonomReal(polynom1.getMonoame().get(i).getPutere(), coefInt1 - coefReal2));
                    } else {
                        coefInt2 = ((MonomInteger) polynom2.getMonoame().get(j)).getCoef();
                        result.addMonom(new MonomInteger(polynom1.getMonoame().get(i).getPutere(), coefInt1 - coefInt2));
                    }
                }
                i++;
                j++;
                if (i == sizePolynom1 || j == sizePolynom2)
                    break;
            }
            if (polynom1.getMonoame().get(i).getPutere() > polynom2.getMonoame().get(j).getPutere()) {
                result.addMonom(polynom1.getMonoame().get(i));
                i++;
                if (i == sizePolynom1)
                    break;
            }
            if (polynom2.getMonoame().get(j).getPutere() > polynom1.getMonoame().get(i).getPutere()) {
                if (polynom2.getMonoame().get(j) instanceof MonomInteger)
                    ((MonomInteger) polynom2.getMonoame().get(j)).setCoef(-1 * ((MonomInteger) polynom2.getMonoame().get(j)).getCoef());
                else
                    ((MonomReal) polynom2.getMonoame().get(j)).setCoef(-1 * ((MonomReal) polynom2.getMonoame().get(j)).getCoef());
                result.addMonom(polynom2.getMonoame().get(j));
                j++;
                if (j == sizePolynom2)
                    break;
            }
        }
        while(i < polynom1.getMonoame().size()){
            result.addMonom(polynom1.getMonoame().get(i));
            i++;
        }
        while(j < polynom2.getMonoame().size()){
            if(polynom2.getMonoame().get(j) instanceof MonomInteger)
                ((MonomInteger) polynom2.getMonoame().get(j)).setCoef(-1*((MonomInteger) polynom2.getMonoame().get(j)).getCoef());
            else
                ((MonomReal) polynom2.getMonoame().get(j)).setCoef(-1*((MonomReal) polynom2.getMonoame().get(j)).getCoef());
            result.addMonom(polynom2.getMonoame().get(j));
            j++;
        }
        return result;
    }

    public static Polynom MuliplyPolynom(Polynom polynom1, Polynom polynom2){
        Polynom result = new Polynom();
        for(Monom monom1 : polynom1.getMonoame()){
            Polynom tmp = new Polynom();
            for(Monom monom2 : polynom2.getMonoame()){
                if(monom1 instanceof MonomInteger){
                    if(monom2 instanceof MonomInteger){
                        tmp.addMonom(new MonomInteger(monom1.getPutere()+ monom2.getPutere(),
                                ((MonomInteger) monom1).getCoef()*((MonomInteger) monom2).getCoef()));
                    }
                    else{
                        tmp.addMonom(new MonomReal(monom1.getPutere()+ monom2.getPutere(),
                                ((MonomInteger) monom1).getCoef()*((MonomReal) monom2).getCoef()));
                    }
                }
                else{
                    if(monom2 instanceof MonomInteger){
                        tmp.addMonom(new MonomReal(monom1.getPutere()+ monom2.getPutere(),
                                ((MonomReal) monom1).getCoef()*((MonomInteger) monom2).getCoef()));
                    }
                    else{
                        tmp.addMonom(new MonomReal(monom1.getPutere()+ monom2.getPutere(),
                                ((MonomReal) monom1).getCoef()*((MonomReal) monom2).getCoef()));
                    }
                }
            }
            result = AddPolynoms(result, tmp);
        }
        return result;
    }

    public static Polynom DividePolynom(Polynom polynom1, Polynom polynom2){
        Polynom result = new Polynom();
        Polynom rest = new Polynom();
        Polynom cat = new Polynom();
        if(polynom1.getMonoame().get(0).getPutere() < polynom2.getMonoame().get(0).getPutere())
            rest = polynom1;
        else{
            while(polynom1.getMonoame().get(0).getPutere() >= polynom2.getMonoame().get(0).getPutere()){
                int difPutere = polynom1.getMonoame().get(0).getPutere() - polynom2.getMonoame().get(0).getPutere();
                Polynom tmp = new Polynom();
                float Coef;
                if(polynom1.getMonoame().get(0) instanceof MonomInteger){
                    Coef = (float)((MonomInteger) polynom1.getMonoame().get(0)).getCoef()/ ((MonomInteger) polynom2.getMonoame().get(0)).getCoef();
                }
                else{
                    Coef = ((MonomReal) polynom1.getMonoame().get(0)).getCoef()/
                            ((MonomInteger) polynom2.getMonoame().get(0)).getCoef();
                }
                tmp.addMonom(new MonomReal(difPutere, Coef));
                cat.addMonom(new MonomReal(difPutere, Coef));
                tmp = MuliplyPolynom(tmp, polynom2);
                polynom1 = SubtractPolynoms(polynom1, tmp);
                int i = 0;
                int size = polynom1.getMonoame().size();
                while(i < size){
                    if(polynom1.getMonoame().get(i) instanceof MonomInteger){
                        if(((MonomInteger) polynom1.getMonoame().get(i)).getCoef() == 0){
                            polynom1.getMonoame().remove(i);
                            size--;
                        }
                    }
                    else{
                        if(Float.compare(((MonomReal) polynom1.getMonoame().get(i)).getCoef(), 0) == 0) {
                            polynom1.getMonoame().remove(i);
                            size--;
                        }
                    }
                    i++;
                }
            }
            rest = polynom1;
        }
        result = cat;
        for(Monom monom: rest.getMonoame()){
            result.addMonom(monom);
        }
        return result;
    }

    public static Polynom DerivativeOfPolynom(Polynom polynom1){
        Polynom result = new Polynom();
        for(Monom monom:polynom1.getMonoame()){
            if(monom.getPutere() > 0){
                ((MonomInteger) monom).setCoef(((MonomInteger) monom).getCoef()* monom.getPutere());
                monom.setPutere(monom.getPutere()-1);
                result.addMonom(monom);
            }
        }
        return result;
    }

    public static Polynom IntegralOfPolynom(Polynom polynom1){
        Polynom result = new Polynom();
        for(Monom monom : polynom1.getMonoame()){
            if(monom.getPutere() > 0){
                monom.setPutere(monom.getPutere()+1);
                if(monom instanceof MonomInteger)
                    result.addMonom(new MonomReal(monom.getPutere(),
                            (float)((MonomInteger) monom).getCoef()/ monom.getPutere()));
                else
                    result.addMonom(new MonomReal(monom.getPutere(),
                            ((MonomReal)monom).getCoef()/ monom.getPutere() ));
            }
            else{
                monom.setPutere(monom.getPutere()+1);
                result.addMonom(monom);
            }
        }
        return result;
    }
}
