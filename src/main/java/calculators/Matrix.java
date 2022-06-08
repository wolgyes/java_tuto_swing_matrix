package calculators;

import java.util.ArrayList;

public class Matrix {
    ArrayList<Vector> matrirx_lines = new ArrayList<>();

    public Matrix(Vector... vectors) throws IllegalArgumentException {
        for (Vector vector : vectors) {
            this.matrirx_lines.add(vector);
        }
    }

    public Matrix(int rows, int columns) throws IllegalArgumentException {
        for (int i = 0; i < rows; i++) {
            this.matrirx_lines.add(new Vector(columns));
        }
    }

    public void addVector(Vector vector){
        this.matrirx_lines.add(vector);
    }
    public void addVerticalVector(Vector vector){
        if (this.matrirx_lines.size() != vector.size()){
            throw new IllegalArgumentException("Size of vectors need to be the same!");
        }
        for (int i = 0; i < vector.size(); i++) {
            this.matrirx_lines.get(i).addElement(vector.vector_values.get(i));
        }
    }

    public float[] getValues() {
        float[] values = new float[this.matrirx_lines.size() * this.matrirx_lines.get(0).size()];
        int i = 0;
        for (Vector vector : this.matrirx_lines) {
            for (float value : vector.getValues()) {
                values[i] = value;
                i++;
            }
        }
        return values;
    }

    public Matrix multiplication(Matrix matrix) throws IllegalArgumentException {
        if (!canMultiplicate(matrix)) {
            throw new IllegalArgumentException("mxn * nxk, bad matrix rows and columns!");
        }

        Matrix resultMatrix = new Matrix();

        assert matrirx_lines.get(0).size() == matrix.matrirx_lines.size() : "width of matrix one must be equal to height of matrix two";
        double[][] product = new double[matrirx_lines.size()][matrix.matrirx_lines.get(0).size()];

        for (short l = 0; l < matrirx_lines.size(); l++) {
            for (short m = 0; m < matrix.matrirx_lines.get(0).size(); m++) {
                product[l][m] = 0;
            }
        }

        for (short i = 0; i < matrirx_lines.size(); i++) {
            for (short j = 0; j < matrix.matrirx_lines.get(0).size(); j++) {
                for (short k = 0; k < matrirx_lines.get(0).size(); k++) {
                    product[i][j] += matrirx_lines.get(i).getValues()[k] * matrix.matrirx_lines.get(k).getValues()[j];
                }
            }
        }


        for (int i = 0; i < product.length; i++) {
            Vector vector = new Vector();
            for (int j = 0; j < product[i].length; j++) {
                vector.addElement(product[i][j]);
            }
            resultMatrix.addVector(vector);
        }
        return resultMatrix;
    }

    public int sizeOfAllElement() {
        return this.getValues().length;
    }


    public Matrix getTransponseMatrix() {
        Matrix new_matrix = new Matrix();
        for (int i = 0; i < this.matrirx_lines.get(0).size(); i++) {
            Vector new_vector = new Vector();
            for (int j = 0; j < this.matrirx_lines.size(); j++) {
                new_vector.addElement(this.matrirx_lines.get(j).vector_values.get(i));
            }
            new_matrix.addVector(new_vector);
        }
        return new_matrix;
    }

    public boolean canMultiplicate(Matrix m){
        return this.matrirx_lines.get(0).size() == m.matrirx_lines.size();
    }

    @Override
    public String toString() {
        // TODO use Matrix class to print your matrix
        StringBuilder sb = new StringBuilder();
        for (Vector vector : this.matrirx_lines) {
            sb.append(vector.toString() + "\n");
        }
        return sb.toString();
    }
}
