package GUI;

import Model.Model;
import Model.Polynom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import static Model.Functions.AddPolynoms;
import static Model.Functions.SubtractPolynoms;
import static Model.Functions.DerivativeOfPolynom;
import static Model.Functions.IntegralOfPolynom;
import static Model.Functions.MuliplyPolynom;
import static Model.Functions.DividePolynom;

public class Controller {
    private View view;
    private Model model;

    public Controller(){}

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        view.addCalculateButtonActionListener(new CalculateButtonActionListener());
    }

    class CalculateButtonActionListener extends Controller implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String getPolynom1 = view.getFirstPolynomial();
            String getPolynom2 = view.getSecondPolynomial();
            if(!model.CheckIfCorrect(getPolynom1) || !model.CheckIfCorrect(getPolynom2))
                view.showError("Polynom1 or Polynom2 is incorrect");
            else {

                Polynom polynom1 = model.ConvertStringToPolynom(getPolynom1);
                Polynom polynom2 = model.ConvertStringToPolynom(getPolynom2);

                Collections.sort(polynom1.getMonoame());
                Collections.sort(polynom2.getMonoame());
                if (view.getOperationBox().equals("Add")) {
                    Polynom result = AddPolynoms(polynom1, polynom2);
                    view.setResult(model.ToString(result));
                }
                if (view.getOperationBox().equals("Subtract")) {
                    Polynom result = SubtractPolynoms(polynom1, polynom2);
                    view.setResult(model.ToString(result));
                }
                if (view.getOperationBox().equals("Derivative")) {
                    Polynom result = DerivativeOfPolynom(polynom1);
                    view.setResult(model.ToString(result));
                }
                if (view.getOperationBox().equals("Integration")) {
                    Polynom result = IntegralOfPolynom(polynom1);
                    view.setResult(model.ToString(result));
                }
                if (view.getOperationBox().equals("Multiplicate")) {
                    Polynom result = MuliplyPolynom(polynom1, polynom2);
                    view.setResult(model.ToString(result));
                }
                if (view.getOperationBox().equals("Divide")) {
                    Polynom result = DividePolynom(polynom1, polynom2);
                    view.setResult(model.ToString(result));
                }
            }
        }
    }

}
