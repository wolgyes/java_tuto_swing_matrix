package outputmanaggers;

import calculators.Matrix;
import calculators.Vector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;


@XmlAccessorType(XmlAccessType.FIELD)
public class ResultInputs {
    private ArrayList<Matrix> inMatrixs;
    private ArrayList<Vector> inVectors;
    private ArrayList<Float> inNums;

    public ResultInputs() {
        this.inMatrixs = new ArrayList<>();
        this.inVectors = new ArrayList<>();
        this.inNums = new ArrayList<>();
    }

    public ResultInputs(Matrix... matrices){
        this.inMatrixs = new ArrayList<>();
        for (Matrix matrix : matrices){
            inMatrixs.add(matrix);
        }
    }

    public ResultInputs(Vector... vectors){
        this.inVectors = new ArrayList<>();
        for (Vector vector : vectors){
            inVectors.add(vector);
        }
    }

    public ResultInputs(Float... nums){
        this.inMatrixs = new ArrayList<>();
        this.inVectors = new ArrayList<>();
        this.inNums = new ArrayList<>();
    }
}
