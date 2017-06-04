import javax.swing.*;

public class Procedures {


    double qualifier(double[][] d) {
        double det = 0;

        if (d.length <= 1) {
            det = d[0][0];
        } else {
            for (int k = 0; k < d.length; k++) {
                double[][] subAr = new double[d.length - 1][d.length - 1];
                for (int i = 0; i < subAr.length; i++) {
                    for (int j = 0; j < k; j++) {
                        subAr[i][j] = d[i + 1][j];
                    }
                    for (int j = k; j < subAr.length; j++) {
                        subAr[i][j] = d[i + 1][j + 1];
                    }
                }
                det += d[0][k] * qualifier(subAr) * ((int) Math.pow(-1, k + 2));
            }
        }

        return det;
    }


    static double[][] sum(double[][] s1, double[][] s2) {
        double[][] total = new double[s1.length][s1[0].length];

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[0].length; j++) {
                total[i][j] = s1[i][j] + s2[i][j];
            }
        }

        return total;
    }


    static double[][] difference(double[][] s1, double[][] s2) {
        double[][] dif = new double[s1.length][s1[0].length];

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[0].length; j++) {
                dif[i][j] = s1[i][j] - s2[i][j];
            }
        }

        return dif;
    }


    static double[][] product(double[][] s1, double[][] s2) {
        double[][] multi = new double[s1.length][s2[0].length];

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2[0].length; j++) {
                multi[i][j] = multiply(i, j, s1, s2);
            }
        }

        return multi;
    }

    static double multiply(int i, int j, double[][] s1, double[][] s2) {
        double ss = 0;

        for (int k = 0; k < s1[0].length; k++) {
            ss += s1[i][k] * s2[k][j];
        }

        return ss;
    }

    static double[][] overturning(double[][] s) {
        double[][] trans = new double[s[0].length][s.length];

        for (int i = 0; i < s[0].length; i++) {
            for (int j = 0; j < s.length; j++) {
                trans[i][j] = s[j][i];
            }
        }

        return trans;
    }


    private double[][][] readMatrices(int s) {

        double[][][] matrix = new double[s][][];

        for (int i = 0; i < s; i++) {  // zapoln mass
            MatrixDialogs matrixDialog = new MatrixDialogs();
            double[][] data = matrixDialog.getData();
            if (data == null)
                return null;
            matrix[i] = data;
            output(matrix[i]); //result
        }

        return matrix;
    }

    public double[][][] number() {
        int s = Integer.parseInt(JOptionPane.showInputDialog("Kol vo matrix = '...'"));

        return readMatrices(s);
    }

    public double[][][] one() {
        return readMatrices(1);
    }

    public void determinant() {
        double[][][] matrix = one();

        if (matrix == null) return;

        if (matrix[0].length != matrix[0][0].length) {
            JOptionPane.showMessageDialog(null, "Error!Matrix be square!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Determination:" + "\n" + qualifier(matrix[0]));
    }

    public void summation() {

        double[][][] matrix = number();

        if (matrix == null) return;
        for (int i = 0; i < matrix.length - 1; i++) {
            if ((matrix[i].length != matrix[i + 1].length) | (matrix[i][0].length != matrix[i + 1][0].length)) {
                JOptionPane.showMessageDialog(null, "Error!Matrix must be same size! ");
                return;
            }
        }

        double[][] sum = matrix[0];

        for (int i = 1; i < matrix.length; i++) {
            sum = sum(sum, matrix[i]);
        }
        result(sum);
    }


    public void subtraction() {

        double[][][] matrix = number();

        if (matrix == null) return;

        for (int i = 0; i < matrix.length - 1; i++) {
            if ((matrix[i].length != matrix[i + 1].length) | (matrix[i][0].length != matrix[i + 1][0].length)) {
                JOptionPane.showMessageDialog(null, "Error!Matrix must be same size! ");
                return;
            }
        }

        double[][] diff = matrix[0];

        for (int i = 1; i < matrix.length; i++) {
            diff = difference(diff, matrix[i]);
        }
        result(diff);
    }

    public void multiplication() {

        double[][][] matrix = number();

        if (matrix == null) return;


        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0].length != matrix[i + 1].length) {
                JOptionPane.showMessageDialog(null, "Errir! ");
                return;
            }
        }

        double[][] prod = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            prod = product(prod, matrix[i]);
        }


        result(prod);
    }

    public void transposition() {

        double[][][] matrix = one();

        if (matrix == null) return;
        result(overturning(matrix[0]));
    }

    void output(double[][] s_out) {

        String out = "Matrix " + s_out.length + "x" + s_out[0].length + ":";
        for (int i = 0; i < s_out.length; i++) {
            out += "\n";
            for (int j = 0; j < s_out[0].length; j++) {
                out += s_out[i][j] + " ";
            }
        }

        JOptionPane.showMessageDialog(null, out);
    }


    void result(double[][] s) {

        String got = "Result " + s.length + "x" + s[0].length + ":";

        for (int i = 0; i < s.length; i++) {
            got += "\n";
            for (int j = 0; j < s[0].length; j++) {
                got += s[i][j] + " ";
            }
        }

        JOptionPane.showMessageDialog(null, got);//
    }
}