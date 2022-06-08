import calculators.Matrix;
import calculators.Vector;

public class MatrixTests {
    public static void main(String[] args) {
        // TODO use Matrix class to test your code

        Matrix simpleMatrix = new Matrix(new Vector(1,2,3), new Vector(4,5,6));
        Matrix simpleMatrix2 = new Matrix(new Vector(2,2,2), new Vector(2,2,2), new Vector(2,2,2));

        System.out.println(simpleMatrix2.multiplication(simpleMatrix));
        System.out.println(simpleMatrix.getTransponseMatrix());
        System.out.println(simpleMatrix2.getTransponseMatrix());
        System.out.println(simpleMatrix2.getInverse());
    }
}
