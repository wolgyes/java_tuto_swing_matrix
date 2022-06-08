package outputmanaggers.outputs;

import calculators.Matrix;
import outputmanaggers.OperationType;
import outputmanaggers.ResultInputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputMatrix extends Output {
    private Matrix outMatrix;

    public OutputMatrix(ResultInputs resultInputs, OperationType operationType, Matrix outMatrix) {
        super(resultInputs, operationType);
        this.outMatrix = outMatrix;

    }
}
