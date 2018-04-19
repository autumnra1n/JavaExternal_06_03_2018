package validation.validator;

import org.xml.sax.SAXException;
import validation.errorhandler.ErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {

    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public static void validate(String fileName, String schemaName){
        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            ErrorHandler sh = new ErrorHandler();
            validator.setErrorHandler(sh);
            validator.validate(source);
            System.out.println(fileName + " is valid.");
        } catch (SAXException e) {
            System.err.print("validation "+ fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because "
                    + e.getMessage());
        }
    }
}
