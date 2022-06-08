package outputmanaggers;

import outputmanaggers.outputs.OutputMatrix;
import outputmanaggers.outputs.OutputNum;
import outputmanaggers.outputs.OutputVector;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
public class OutputManagger {


    @XmlElementWrapper(name = "matrixOutputs")
    public ArrayList<OutputMatrix> matrixCalcs;

    @XmlElementWrapper(name = "matrixOutputs")
    public ArrayList<OutputVector> vectorCalcs;

    public ArrayList<OutputNum> outputNums;

    public OutputManagger() {
        matrixCalcs = new ArrayList<>();
        vectorCalcs = new ArrayList<>();
        outputNums = new ArrayList<>();
    }
}
