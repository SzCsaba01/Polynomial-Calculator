package Model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FunctionsTest extends TestCase {

    @Test
    void ToString() {
        Polynom polynom1 = new Polynom();
        Model model = new Model();
        polynom1.addMonom(new MonomInteger(3, -3));
        polynom1.addMonom(new MonomInteger(2, 11));
        polynom1.addMonom(new MonomInteger(1, 12));
        polynom1.addMonom(new MonomInteger(0, -3));//-3*x^3+11*x^2+12*x-3

        String test = model.ToString(polynom1);
        Assertions.assertEquals(test, "-3*x^3+11*x^2+12*x-3");

    }

    @Test
    void convertStringToPolynom() {
        Polynom polynom1 = new Polynom();
        Model model = new Model();
        String test = "-3*x^3+11*x^2+12*x-3";
        polynom1 = model.ConvertStringToPolynom(test);

        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 3);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(0)).getCoef(), -3);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 2);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(1)).getCoef(), 11);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(2)).getCoef(), 12);

        Assertions.assertEquals(polynom1.getMonoame().get(3).getPutere(), 0);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(3)).getCoef(), -3);
    }

    @Test
    void addPolynoms() {
        Polynom polynom1 = new Polynom();
        Polynom polynom2 = new Polynom();

        polynom1.addMonom(new MonomInteger(3, -3));
        polynom1.addMonom(new MonomInteger(2, 11));
        polynom1.addMonom(new MonomInteger(1, 12));
        polynom1.addMonom(new MonomInteger(0, -3));//-3*x^3+11*x^2+12*x-3

        polynom2.addMonom(new MonomInteger(4, 1));
        polynom2.addMonom(new MonomInteger(3, 5));
        polynom2.addMonom(new MonomInteger(2, -3));
        polynom2.addMonom(new MonomInteger(1, 2));//x^4+5*x^3-3*x^2+2*x

        polynom1 = Functions.AddPolynoms(polynom1,polynom2);//x^4+2*x^3+8*x^2+14*x-3
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 4);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(0)).getCoef(), 1);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 3);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(1)).getCoef(), 2);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 2);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(2)).getCoef(), 8);

        Assertions.assertEquals(polynom1.getMonoame().get(3).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(3)).getCoef(), 14);

        Assertions.assertEquals(polynom1.getMonoame().get(4).getPutere(), 0);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(4)).getCoef(), -3);

    }

    @Test
    void subtractPolynoms() {
        Polynom polynom1 = new Polynom();
        Polynom polynom2 = new Polynom();

        polynom1.addMonom(new MonomInteger(3, 3));
        polynom1.addMonom(new MonomInteger(2, 11));
        polynom1.addMonom(new MonomInteger(1, 12));
        polynom1.addMonom(new MonomInteger(0, -3));//-3*x^3+11*x^2+12*x-3

        polynom2.addMonom(new MonomInteger(4, 1));
        polynom2.addMonom(new MonomInteger(3, 5));
        polynom2.addMonom(new MonomInteger(2, -3));
        polynom2.addMonom(new MonomInteger(1, 2));//x^4+5*x^3-3*x^2+2*x

        polynom1 = Functions.SubtractPolynoms(polynom1,polynom2);//-x^4-2*x^3+14*x^2+10*x-3
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 4);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(0)).getCoef(), -1);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 3);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(1)).getCoef(), -2);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 2);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(2)).getCoef(), 14);

        Assertions.assertEquals(polynom1.getMonoame().get(3).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(3)).getCoef(), 10);

        Assertions.assertEquals(polynom1.getMonoame().get(4).getPutere(), 0);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(4)).getCoef(), -3);
    }

    @Test
    void muliplyPolynom() {
        Polynom polynom1 = new Polynom();
        Polynom polynom2 = new Polynom();

        polynom1.addMonom(new MonomInteger(1, 12));
        polynom1.addMonom(new MonomInteger(0, -3));//12*x-3

        polynom2.addMonom(new MonomInteger(2, -3));
        polynom2.addMonom(new MonomInteger(1, 2));//-3*x^2+2*x

        polynom1 = Functions.MuliplyPolynom(polynom1,polynom2);//-36*x^3+33*x^2-6*x
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 3);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(0)).getCoef(), -36);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 2);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(1)).getCoef(), 33);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(2)).getCoef(), -6);

    }

    @Test
    void dividePolynom() {
        Polynom polynom1 = new Polynom();
        Polynom polynom2 = new Polynom();

        polynom1.addMonom(new MonomInteger(2, 2));
        polynom1.addMonom(new MonomInteger(1, 2));//2*x^2+2*x

        polynom2.addMonom(new MonomInteger(1, 10));
        polynom2.addMonom(new MonomInteger(0, -3));//10*x-3

        polynom1 = Functions.DividePolynom(polynom1,polynom2);//0.2*x+0.26+0.78
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 1);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(0)).getCoef(), 0.20000000298023224);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 0);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(1)).getCoef(), 0.25999999046325684);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 0);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(2)).getCoef(), 0.7799999713897705);
    }

    @Test
    void derivativeOfPolynom() {
        Polynom polynom1 = new Polynom();

        polynom1.addMonom(new MonomInteger(3, -3));
        polynom1.addMonom(new MonomInteger(2, 11));
        polynom1.addMonom(new MonomInteger(1,12));
        polynom1.addMonom(new MonomInteger(0, -3));//-3*x^3+11*x^2+12*x-3

        polynom1 = Functions.DerivativeOfPolynom(polynom1);//-9*x^2+22*x+12
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 2);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(0)).getCoef(), -9);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(1)).getCoef(), 22);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 0);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(2)).getCoef(), 12);

    }

    @Test
    void integralOfPolynom() {
        Polynom polynom1 = new Polynom();

        polynom1.addMonom(new MonomInteger(3,-3));
        polynom1.addMonom(new MonomInteger(2, 11));
        polynom1.addMonom(new MonomInteger(1, 12));
        polynom1.addMonom(new MonomInteger(0, -3));//-3*x^3+11*x^2+12*x-3

        polynom1 = Functions.IntegralOfPolynom(polynom1);//-0.75*x^4+3.6666667461395264*x^3+6*x^2-3*x
        Assertions.assertEquals(polynom1.getMonoame().get(0).getPutere(), 4);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(0)).getCoef(), -0.75);

        Assertions.assertEquals(polynom1.getMonoame().get(1).getPutere(), 3);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(1)).getCoef(), 3.6666667461395264);

        Assertions.assertEquals(polynom1.getMonoame().get(2).getPutere(), 2);
        Assertions.assertEquals(((MonomReal)polynom1.getMonoame().get(2)).getCoef(), 6.0);

        Assertions.assertEquals(polynom1.getMonoame().get(3).getPutere(), 1);
        Assertions.assertEquals(((MonomInteger)polynom1.getMonoame().get(3)).getCoef(), -3);

    }
}