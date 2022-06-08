package outputmanaggers.outputs;

import outputmanaggers.OperationType;
import outputmanaggers.ResultInputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
abstract class Output {
    protected ResultInputs resultInputs;
    protected OperationType operationType;

    public Output(ResultInputs resultInputs, OperationType operationType) {
        this.resultInputs = resultInputs;
        this.operationType = operationType;
    }
}
