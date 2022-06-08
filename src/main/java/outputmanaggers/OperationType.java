package outputmanaggers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.PROPERTY)
public enum OperationType {
    sum, addition, subtraction, magnitude, multiplyByScalar, findUnitVector, dotProduct, multiplication, transpose,
}
