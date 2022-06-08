import calculators.Matrix;
import calculators.Vector;

public class MatrixTests {
    public static void main(String[] args) {
        // TODO use Matrix class to test your code

        Matrix simpleMatrix = new Matrix(
                new Vector(1,2,3),
                new Vector(4,5,6),
                new Vector(4,5,6));

        Matrix simpleMatrix2 = new Matrix(
                new Vector(2,2),
                new Vector(2,2),
                new Vector(2,2));

        Matrix simpleMatrix3 = new Matrix(
                new Vector(1,2,3),
                new Vector(4,5,6),
                new Vector(4,5,6));




        System.out.println("sm2 x sm: ");
        if(simpleMatrix2.canMultiplicate(simpleMatrix)) {
            System.out.println(simpleMatrix2.multiplication(simpleMatrix) + "\n");
        }else{
            System.out.println("Can't multiplicate");
        }

        System.out.println("\nsm x sm2: ");
        if(simpleMatrix.canMultiplicate(simpleMatrix2)) {
            System.out.println(simpleMatrix.multiplication(simpleMatrix2) + "\n");
        }else{
            System.out.println("Can't multiplicate");
        }

        System.out.println("\nsm x T sm2: ");
        if(simpleMatrix.canMultiplicate(simpleMatrix2.getTransponseMatrix())) {
            System.out.println(simpleMatrix.multiplication(simpleMatrix2.getTransponseMatrix()) + "\n");
        }else{
            System.out.println("Can't multiplicate");
        }

        System.out.println("\nOther things: ");
        System.out.println(simpleMatrix.getTransponseMatrix() + "\n");
        System.out.println(simpleMatrix2.getTransponseMatrix() + "\n");
        System.out.println(simpleMatrix.getTransponseMatrix().getTransponseMatrix() + "\n");
        System.out.println(simpleMatrix.additionalMatrix(simpleMatrix3) + "\n");
        try {
            System.out.println(simpleMatrix.additionalMatrix(simpleMatrix2));
        } catch (IllegalArgumentException e) {
            System.out.println("-------------------------");
            System.out.println(e.getMessage());
            System.out.println(simpleMatrix + "\n\n" + simpleMatrix2);
            System.out.println("-------------------------");
        }

        System.out.println("Matrix sum: " + simpleMatrix.calcSum());
        System.out.println("Matrix sum: " + simpleMatrix2.calcSum());
    }
}
