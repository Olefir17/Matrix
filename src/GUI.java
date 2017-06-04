import javax.swing.*;
public class GUI {
    public static void main(String[] args) {
        Procedures method = new Procedures();

        JOptionPane.showMessageDialog(null, "Hello,your work with MatrixCalc (Ver1.0)." + "\n" + "\n" + "Choose operation");

        while (true) {
            String text = "Enter number:" + "\n" + "\n" + "1 - Determinant" + "\n" + "2 - Sum" + "\n" + "3 - Difference" + "\n" + "4 - Multiplication" + "\n" + "5 - Transpose matrix" + "\n" + "\n" + "0 - Exit";
            // JOptionPane.showInputDialog(1);
            int h = Integer.parseInt(JOptionPane.showInputDialog(text));//text in int
            switch (h) {
                case 1:
                    method.determinant();
                    break;
                case 2:
                    method.summation();
                    break;
                case 3:
                    method.subtraction();
                    break;
                case 4:
                    method.multiplication();
                    break;
                case 5:
                    method.transposition();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Thank you for using our program!" + "\n" + "\n");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Error.Enter again!");
            }
        }
    }
}