package control;

import model.Matrix;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Manager {

    public static final String FILENAME = "matrix.xml";

    private File file;
    private JAXBContext jaxbContext;

    public Manager() throws JAXBException {
        file = new File(FILENAME);
        jaxbContext = JAXBContext.newInstance(Matrix.class);
    }

    public Matrix getMatrix() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Matrix) unmarshaller.unmarshal(file);
    }

    public void setMatrix(Matrix matrix) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(matrix, file);
    }
}
