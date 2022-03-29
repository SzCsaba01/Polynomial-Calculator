package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JLabel firstPolynomialLabel;
    private JLabel secondPolynomialLabel;
    private JTextField firstPolynomialTextField;
    private JTextField secondPolynomialTextField;
    private JComboBox operationComboBox;
    private JLabel operationLabel;
    private JLabel resultLabel;
    private JTextField resultTextField;
    private JPanel MainPanel;
    private JButton calculateButton;
    private JFrame frame;

    public View(){
        frame = new JFrame("Calculator");
        frame.setContentPane(MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultTextField.setEditable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void showError(String errMessage) {JOptionPane.showMessageDialog(this, errMessage);}
    public void addCalculateButtonActionListener(ActionListener e) {calculateButton.addActionListener(e);}
    public String getFirstPolynomial(){return firstPolynomialTextField.getText();}
    public String getSecondPolynomial(){return secondPolynomialTextField.getText();}
    public void setResult(String txt){resultTextField.setText(txt);}
    public Object getOperationBox(){return operationComboBox.getSelectedItem();}
}
