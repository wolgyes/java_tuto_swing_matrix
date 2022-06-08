package outputmanaggers.outputs;

import calculators.Vector;
import outputmanaggers.OperationType;
import outputmanaggers.ResultInputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputVector extends Output {

    public Vector outVector;

    public OutputVector(ResultInputs resultInputs, OperationType operationType, Vector outVector) {
        super(resultInputs, operationType);
        this.outVector = outVector;

    }
}
