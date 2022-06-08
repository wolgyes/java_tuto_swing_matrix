package calculators;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector<T>{
    public List<T> list = new ArrayList<>();

    private Class<T> type;

    @SafeVarargs
    public Vector(T... xs) throws IllegalArgumentException{

        type = (Class<T>) xs.getClass().getComponentType();

        for(T x : xs){
            this.add(x);
        }

    }

    public float calcMagnitude(){
        double sum = 0;
        for(T x : list){
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
                resultVector.add (Float.parseFloat(this.list.get(i).toString()) - Float.parseFloat(vector.list.get(i).toString()));
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
                resultVector.add (Float.parseFloat(this.list.get(i).toString()) + Float.parseFloat(vector.list.get(i).toString()));
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> findUnitVector(){
        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < this.size(); i++) {
            try {
                resultVector.add (Float.parseFloat(this.list.get(i).toString()) / this.calcMagnitude());
            }
            catch (Exception ignore){}
        }

        return resultVector;
    }

    public Vector<?> multiplyByScalar(float scalar){
        Vector<Float> resultVector = new Vector<>();
        for (int i = 0; i < this.size(); i++) {
            try {
                resultVector.add ((float) (Float.parseFloat(this.list.get(i).toString()) * scalar));
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
                sum += Float.parseFloat(this.list.get(i).toString()) * Float.parseFloat(vector.list.get(i).toString());
            }
            catch (Exception ignore){}
        }

        return sum;
    }

    public void add(T value) throws IllegalArgumentException{
        if(!(value instanceof Integer || value instanceof Float || value instanceof Double)){
            throw new IllegalArgumentException("T must be Integer, Float or double!");
        }
        list.add(value);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (T d: list) {
            sb.append(d).append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(">");
        return sb.toString();
    }

    public Object getTypeOfObecjt() {
        return type.getName();
    }
}