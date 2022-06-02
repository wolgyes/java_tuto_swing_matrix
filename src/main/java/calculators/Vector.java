package calculators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector<T>{

    //TODO type meghatarozasa somehow;
    private Class<T> type;
    public List<T> list = new ArrayList<>();

    @SafeVarargs
    public Vector(T... xs) throws IllegalArgumentException{

        for(T x : xs){
            this.add(x);
        }

    }

    public double calcMagnitude(){
        double sum = 0;
        for(T x : list){
            sum += Math.pow(Double.parseDouble(x.toString()), 2);
        }
        return Math.sqrt(sum);
    }

    public Vector<?> calcSubtraction(Vector<?> vector) throws IndexOutOfBoundsException {
        if (vector.size() != this.size()) {
            throw new IndexOutOfBoundsException("Size of vectors need to be the same!");
        }

        Vector<Float> resultVector = new Vector<>();
        //kulonbseg 2 valamilyen (?) vector kozott, nemtudom mit csinal es hogyan mukodhet, de ha hozzaersz szetesik minden a pics...
        for (int i = 0; i < vector.size(); i++) {
            try {
                resultVector.add(Float.parseFloat(this.list.get(i).toString())- Float.parseFloat(vector.list.get(i).toString()));
            }
            catch (Exception ignore){}
        }

        return resultVector;
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
        sb.replace (sb.length()-1, sb.length(), "");
        sb.append(">");
        return sb.toString();
    }

    public Object getTypeOfElements() {
        return type;
    }
}