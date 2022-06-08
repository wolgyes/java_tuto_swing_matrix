import calculators.Matrix;
import calculators.Vector;
import outputmanaggers.OperationType;
import outputmanaggers.OutputManagger;
import outputmanaggers.ResultInputs;
import outputmanaggers.XmlManagger;
import outputmanaggers.outputs.OutputMatrix;
import outputmanaggers.outputs.OutputNum;
import outputmanaggers.outputs.OutputVector;

public class XMLtest {
    public static void main(String[] args) {
        XmlManagger.om.matrixCalcs.add(
                new OutputMatrix(
                        new ResultInputs(
                                new Matrix(
                                        new Vector(1, 2, 3),
                                        new Vector(4, 5, 6),
                                        new Vector(7, 8, 9)),
                                new Matrix(
                                        new Vector(1, 2, 3),
                                        new Vector(4, 5, 6),
                                        new Vector(7, 8, 9))


                        ),
                        OperationType.addition,
                        new Matrix(
                                new Vector(2, 4, 6),
                                new Vector(8, 10, 12),
                                new Vector(14, 16, 18)
                        )
                )
        );
        XmlManagger.om.matrixCalcs.add(
                new OutputMatrix(
                        new ResultInputs(
                                new Matrix(
                                        new Vector(1, 2, 3),
                                        new Vector(4, 5, 6),
                                        new Vector(7, 8, 9)),
                                new Matrix(
                                        new Vector(1, 2, 3),
                                        new Vector(4, 5, 6),
                                        new Vector(7, 8, 9))


                        ),
                        OperationType.subtraction,
                        new Matrix(
                                new Vector(2, 4, 6),
                                new Vector(8, 10, 12),
                                new Vector(14, 16, 18)
                        )
                )
        );
        XmlManagger.xmlWrite();
//        om.add(
//                new OutputMatrix(
//                        new ResultInputs(new Matrix(), new Matrix()),
//                        OperationType.transpose,
//                        new Matrix()
//                )
//        );
//        om.outputNums.add(
//                new OutputNum(
//                        new ResultInputs(new Matrix(), new Matrix()),
//                        OperationType.addition,
//                        2f
//                )
//        );
//
//        om.vectorCalcs.add(
//                new OutputVector(
//                        new ResultInputs(new Matrix(), new Matrix()),
//                        OperationType.addition,
//                        new Vector()
//                )
//        );
    }
}
