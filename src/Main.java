import model.Matrix;
import view.View;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            View view = new View();
            view.setVisible(true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
