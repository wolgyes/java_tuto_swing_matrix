import calculators.Vector;

public class VectorTests {
    public static void main(String[] args) {
        Vector<Integer> simpleVector = new Vector<>(1,2,3);
        System.out.println(simpleVector);

        System.out.println("Magnitude: " + simpleVector.calcMagnitude());
        System.out.println("Subtraction: " + simpleVector.calcSubtraction(new Vector<>(1,2,-3)));
        System.out.println("Addition: " + simpleVector.calcAddition(new Vector<>(1,2,-3)));
        System.out.println("Scalar multiplication: " + simpleVector.multiplyByScalar(2));
        System.out.println("Dot (INNER) Product: " + simpleVector.calcDotProduct(new Vector<>(1,2,-3)));
        System.out.println("Find Unit Vector: " + simpleVector.findUnitVector());
        System.out.println("Find Projection: " + simpleVector.calcVectorProjection(new Vector<>(1,2,-3)));


    }
}
