import calculators.Vector;

public class VectorTests {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(3,-5);
        vector.add(0);
        System.out.println(vector.calcMagnitude());
        Vector<?> v = vector.calcSubtraction(new Vector<>(1,2, -3));
        System.out.println(v.getTypeOfElements());
    }
}
