package service;

import persistence.model.Product;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StAXService implements XMLService {
    private XMLInputFactory inputFactory;
    public StAXService() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals("product")) {
                        Product product = buildProduct(reader);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
    }
    private Product buildProduct(XMLStreamReader reader) throws XMLStreamException {
        Product product = new Product();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "id":
                            product.setId((Integer.valueOf(getXMLText(reader))));
                            break;
                        case "name":
                            product.setName(getXMLText(reader));
                            break;
                        case "price":
                            product.setId((Integer.valueOf(getXMLText(reader))));
                            break;
                        case "weight":
                            product.setId((Integer.valueOf(getXMLText(reader))));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("product")) {
                        return product;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}


