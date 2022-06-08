package calculators;
import java.util.ArrayList;
import java.util.List;

public class Vector<T>{
    public List<T> vector_values = new ArrayList<>();

    private Class<T> type;

    @SafeVarargs
    public Vector(T... xs) throws IllegalArgumentException{

        type = (Class<T>) xs.getClass().getComponentType();

        for(T x : xs){
            this.addElement(x);
        }

    }
    public Vector(Vector<T> vector) throws IllegalArgumentException{
        vector_values = vector.vector_values;
    }

    public float calcMagnitude(){
        double sum = 0;
        for(T x : vector_values){
            sum += Math.pow(Double.parseDouble(x.toString()), 2);
        }
        return (float) Math.sqrt(sum);
    }

    public Vector<?> calcSubtraction(Vector<?> vector) throws IndexOutOfBoundsException {
        if (vector.size() != this.size()) {
            throw new IndexOutOfBoundsException("Size of vectors need to be the same!");
        }

        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < vector.size(); i++) {
            try {
                resultVector.addElement(Float.parseFloat(this.vector_values.get(i).toString()) - Float.parseFloat(vector.vector_values.get(i).toString()));
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> calcAddition(Vector<?> vector) throws IndexOutOfBoundsException {
        if (vector.size() != this.size()) {
            throw new IndexOutOfBoundsException("Size of vectors need to be the same!");
        }

        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < vector.size(); i++) {
            try {
                resultVector.addElement(Float.parseFloat(this.vector_values.get(i).toString()) + Float.parseFloat(vector.vector_values.get(i).toString()));
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> findUnitVector(){
        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < this.size(); i++) {
            try {
                resultVector.addElement(Float.parseFloat(this.vector_values.get(i).toString()) / this.calcMagnitude());
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> multiplyByScalar(float scalar){
        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < this.size(); i++) {
            try {
                resultVector.addElement((float) (Float.parseFloat(this.vector_values.get(i).toString()) * scalar));
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> calcVectorProjection(Vector<?> vector) throws IndexOutOfBoundsException {
        if (vector.size() != this.size()) {
            throw new IndexOutOfBoundsException("Size of vectors need to be the same!");
        }
        return this.multiplyByScalar(vector.calcDotProduct(this) / (float) Math.pow(this.calcMagnitude(), 2));
    }

    public float calcDotProduct(Vector<?> vector) throws IndexOutOfBoundsException {
        if (vector.size() != this.size()) {
            throw new IndexOutOfBoundsException("Size of vectors need to be the same!");
        }

        float sum = 0;
        for (int i = 0; i < vector.size(); i++) {
            try {
                sum += Float.parseFloat(this.vector_values.get(i).toString()) * Float.parseFloat(vector.vector_values.get(i).toString());
            }
            catch (Exception ignore){}
        }

        return sum;
    }

    public void addElement(T value) throws IllegalArgumentException{
        if(!(value instanceof Integer || value instanceof Float || value instanceof Double)){
            throw new IllegalArgumentException("T must be Integer, Float or double!");
        }
        vector_values.add(value);
    }

    public int size() {
        return vector_values.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (T d: vector_values) {
            sb.append(d).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(">");
        return sb.toString();
    }

    public float[] getValues() {
        float[] values = new float[vector_values.size()];
        for (int i = 0; i < vector_values.size(); i++) {
            values[i] = Float.parseFloat(vector_values.get(i).toString());
        }
        return values;
    }

    public float sumVectorElements() {
        float sum = 0;
        for (T x : vector_values) {
            sum += Float.parseFloat(x.toString());
        }
        return sum;
    }
}