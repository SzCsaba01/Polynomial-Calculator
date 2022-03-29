package Model;

public class Model {
    public String ToString(Polynom polynom){
        String result = "";
        if(polynom.getMonoame().get(0) instanceof MonomInteger){
            if(((MonomInteger) polynom.getMonoame().get(0)).getCoef() > 1) {
                result = result + ((MonomInteger) polynom.getMonoame().get(0)).getCoef();
                if(polynom.getMonoame().get(0).getPutere() > 1)
                    result = result + "*x^" + polynom.getMonoame().get(0).getPutere();
                else{
                    if(polynom.getMonoame().get(0).getPutere() == 1)
                        result = result + "*x";
                }
            }
            else{
                if(((MonomInteger) polynom.getMonoame().get(0)).getCoef() == 1) {
                    if (polynom.getMonoame().get(0).getPutere() > 1)
                        result = result + "x^" + polynom.getMonoame().get(0).getPutere();
                    else {
                        if (polynom.getMonoame().get(0).getPutere() == 1)
                            result = result + "x";
                        else
                            result = result + "1";
                    }
                }
                else{
                    if(((MonomInteger) polynom.getMonoame().get(0)).getCoef() == -1){
                        if(polynom.getMonoame().get(0).getPutere() > 1)
                            result = result + "-x^" + polynom.getMonoame().get(0).getPutere();
                        else{
                            if(polynom.getMonoame().get(0).getPutere() == 1)
                                result = result + "-x";
                            else
                                result = result + "-1";
                        }
                    }
                    if(((MonomInteger) polynom.getMonoame().get(0)).getCoef() < -1){
                        result = result + ((MonomInteger) polynom.getMonoame().get(0)).getCoef();
                        if(polynom.getMonoame().get(0).getPutere() > 1)
                            result = result +"*x^" + polynom.getMonoame().get(0).getPutere();
                        if(polynom.getMonoame().get(0).getPutere() == 1)
                            result = result + "*x";

                    }
                }
            }
        }
        else{
            if(Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(),0) > 0 &&
                    Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(),1) != 0){
                result = result + ((MonomReal) polynom.getMonoame().get(0)).getCoef();
                if(polynom.getMonoame().get(0).getPutere() > 1)
                    result = result + "*x^" + polynom.getMonoame().get(0).getPutere();
                if(polynom.getMonoame().get(0).getPutere() == 1)
                    result = result + "*x";

            }
            else{
                if(Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(), 1) == 0) {
                    if (polynom.getMonoame().get(0).getPutere() > 1)
                        result = result + "x^" + polynom.getMonoame().get(0).getPutere();
                    else {
                        if (polynom.getMonoame().get(0).getPutere() == 1)
                            result = result + "x";
                        else
                            result = result + ((MonomReal) polynom.getMonoame().get(0)).getCoef();
                    }
                }
                else{
                    if(Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(), -1) == 0){
                        if(polynom.getMonoame().get(0).getPutere() > 1)
                            result = result + "-x^" + polynom.getMonoame().get(0).getPutere();
                        else{
                            if(polynom.getMonoame().get(0).getPutere() == 1)
                                result = result + "-x";
                            else
                                result = result + "-1";
                        }
                    }
                    if(Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(),0) < 0 &&
                            Float.compare(((MonomReal) polynom.getMonoame().get(0)).getCoef(),-1) != 0){
                        result = result + ((MonomReal) polynom.getMonoame().get(0)).getCoef();
                        if(polynom.getMonoame().get(0).getPutere() > 1)
                            result = result +"*x^" + polynom.getMonoame().get(0).getPutere();
                        if(polynom.getMonoame().get(0).getPutere() == 1)
                            result = result + "*x";
                    }
                }
            }
        }
        int i = 1;
        int sizePolynom = polynom.getMonoame().size();
        while(i < sizePolynom){
            if(polynom.getMonoame().get(i) instanceof MonomInteger){
                if(((MonomInteger) polynom.getMonoame().get(i)).getCoef() > 1){
                    result = result + "+" + ((MonomInteger) polynom.getMonoame().get(i)).getCoef();
                    if(polynom.getMonoame().get(i).getPutere() > 1)
                        result = result + "*x^" + polynom.getMonoame().get(i).getPutere();
                    if(polynom.getMonoame().get(i).getPutere() == 1)
                        result = result + "*x";
                }
                else{
                    if(((MonomInteger) polynom.getMonoame().get(i)).getCoef() == 1){
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result + "+x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "+x";
                        if(polynom.getMonoame().get(i).getPutere() == 0)
                            result = result + "+" + ((MonomInteger) polynom.getMonoame().get(i)).getCoef();
                    }
                    if(((MonomInteger) polynom.getMonoame().get(i)).getCoef() == -1){
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result + "-x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "-x";
                        if(polynom.getMonoame().get(i).getPutere() == 0)
                            result = result + ((MonomInteger) polynom.getMonoame().get(i)).getCoef();
                    }
                    if(((MonomInteger) polynom.getMonoame().get(i)).getCoef() < -1){
                        result = result + ((MonomInteger) polynom.getMonoame().get(i)).getCoef();
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result +"*x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "*x";
                    }
                }
            }
            else{
                if(Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),0) > 0 &&
                        Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),1) != 0){
                    result = result + "+" + ((MonomReal) polynom.getMonoame().get(i)).getCoef();
                    if(polynom.getMonoame().get(i).getPutere() > 1)
                        result = result + "*x^" + polynom.getMonoame().get(i).getPutere();
                    if(polynom.getMonoame().get(i).getPutere() == 1)
                        result = result + "*x";
                }
                else{
                    if(Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),1) == 0){
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result + "+x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "+x";
                        if(polynom.getMonoame().get(i).getPutere() == 0)
                            result = result + "+" + ((MonomReal) polynom.getMonoame().get(i)).getCoef();
                    }
                    if(Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),-1) == 0){
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result + "-x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "-x";
                        if(polynom.getMonoame().get(i).getPutere() == 0)
                            result = result + ((MonomReal) polynom.getMonoame().get(i)).getCoef();
                    }
                    if(Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),0) < 0 &&
                            Float.compare(((MonomReal) polynom.getMonoame().get(i)).getCoef(),-1) != 0){
                        result = result + ((MonomReal) polynom.getMonoame().get(i)).getCoef();
                        if(polynom.getMonoame().get(i).getPutere() > 1)
                            result = result +"*x^" + polynom.getMonoame().get(i).getPutere();
                        if(polynom.getMonoame().get(i).getPutere() == 1)
                            result = result + "*x";
                    }
                }
            }
            i++;
        }
        return result;
    }

    public Polynom ConvertStringToPolynom(String polynom){
        Polynom result = new Polynom();
        polynom = polynom.replace("-", ",-");
        String[] tokens = polynom.split(",|\\+");
        for(String tmp : tokens) {
            if (tmp.length() >= 1) {
                int negativ = 1;
                int coefint = 0;
                int putere = 0;
                tmp = tmp.replace("*", "");
                tmp = tmp.replace("^", "");
                tmp = tmp.replace(" ", "");
                String coef = "";
                String put = "";
                int ok = 0;
                if (tmp.equals("x")) {
                    result.addMonom(new MonomInteger(1, 1));
                } else {
                    if (tmp.length() > 1) {
                        for (char c : tmp.toCharArray()) {
                            if (c == '-')
                                negativ = -1;
                            if (c == 'x')
                                ok = 1;
                            if (ok == 0 && c != '-')
                                coef = coef + c;
                            else if (c != 'x' && c != '-')
                                put = put + c;
                        }
                        if (coef.equals(""))
                            coef = "1";
                        if (put.equals("") && ok == 1)
                            put = "1";
                    }
                    if (ok == 0) {
                        try {
                            coefint = Integer.parseInt(tmp);
                        } catch (NumberFormatException e) {}
                        result.addMonom(new MonomInteger(0, coefint));
                    } else {
                        try {
                            coefint = Integer.parseInt(coef);
                        } catch (NumberFormatException e) {}
                        putere = Integer.parseInt(put);
                        result.addMonom(new MonomInteger(putere, negativ * coefint));
                    }
                }
            }
        }
        return result;
    }

    public boolean CheckIfCorrect(String polynom){
        polynom = polynom.replace("-", ",-");
        String[] tokens = polynom.split(",|\\+");
        int multipleNumbers = 0;
        for(String tmp : tokens){
            int numberInt = 0;
            int multipleX = 0;
            int multiplePutere = 0;
            int multipleMultiply = 0;
            int multipleMinus = 0;
            String digit = "";
            tmp = tmp.replace(" ", "");
            for(char c : tmp.toCharArray()){
                if(c != 'x' && c != '^' && c != '*' && !Character.isDigit(c) && c != '-')
                    return false;
                else{
                    if(Character.isDigit(c) || c == '.')
                        digit += c;
                }
                if(c =='^') {
                    multiplePutere++;
                    if (multiplePutere > 1)
                        return false;
                }
                if(c == '*') {
                    multipleMultiply++;
                    if (multipleMultiply > 1)
                        return false;
                    if(digit.equals(""))
                        return false;
                    digit = "";
                }
                if(c == 'x') {
                    multipleX++;
                    if (multipleX > 1)
                        return false;
                    if(!digit.equals(""))
                        return false;
                }
                if(c == '-'){
                    multipleMinus++;
                    if(multipleMinus > 1)
                        return false;
                }
            }
            if(tmp.toCharArray().length > 1) {
                if (tmp.toCharArray()[tmp.toCharArray().length-1] == '^')
                    return false;
                if(Character.isDigit(tmp.toCharArray()[tmp.toCharArray().length-1]) && multiplePutere == 0 && multipleX > 0)
                    return false;
            }
            try{
                numberInt = Integer.parseInt(tmp);
            }catch (NumberFormatException e){}
            if(numberInt != 0)
                multipleNumbers++;
            if(multipleNumbers > 1)
                return false;
        }
        return true;
    }
}
