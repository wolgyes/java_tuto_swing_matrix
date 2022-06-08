package outputmanaggers;

import calculators.Matrix;
import calculators.Vector;
import outputmanaggers.outputs.OutputMatrix;
import outputmanaggers.outputs.OutputNum;
import outputmanaggers.outputs.OutputVector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;

public class XmlManagger {

    public static File file = new File("outputs.xml");
    public static OutputManagger om = new OutputManagger();

    public XmlManagger() {
        xmlLoad();
    }


    public static void xmlLoad(){
        try {
            JAXBContext jc = JAXBContext.newInstance(OutputManagger.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            om = (OutputManagger) unmarshaller.unmarshal(file);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void xmlWrite(){
        try {
            JAXBContext context = JAXBContext.newInstance(OutputManagger.class);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marsh.marshal(om, new File(String.valueOf(file)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
