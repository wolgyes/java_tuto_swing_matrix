package outputmanaggers.outputs;

import outputmanaggers.OperationType;
import outputmanaggers.ResultInputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputNum extends Output {

    private Float outNum;

    public OutputNum(ResultInputs resultInputs, OperationType operationType, Float outFloat) {
        super(resultInputs, operationType);
        this.outNum = outFloat;

    }

}
