package service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

public class DOMService {

    public void createProductDocument(int id, String name, int price, int weight, String file) {
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        String root = "Product";
        Element rootElement = document.createElement(root);
        document.appendChild(rootElement);
        String elementId = "id";
        Element emId = document.createElement(elementId);
        emId.appendChild(document.createTextNode(String.valueOf(id)));
        String elementName = "name";
        Element emName = document.createElement(elementName);
        emName.appendChild(document.createTextNode(name));
        String elementPrice = "price";
        Element emPrice = document.createElement(elementPrice);
        emPrice.appendChild(document.createTextNode(String.valueOf(price)));
        String elementWeight = "weight";
        Element emWeight = document.createElement(elementWeight);
        emWeight.appendChild(document.createTextNode(String.valueOf(weight)));
        rootElement.appendChild(emId);
        rootElement.appendChild(emName);
        rootElement.appendChild(emPrice);
        rootElement.appendChild(emWeight);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(file));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

    public void createCategoryDocument(int id, String name, String file){
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        String root = "Category";
        Element rootElement = document.createElement(root);
        document.appendChild(rootElement);
        String elementId = "id";
        Element emId = document.createElement(elementId);
        emId.appendChild(document.createTextNode(String.valueOf(id)));
        String elementName = "name";
        Element emName = document.createElement(elementName);
        emName.appendChild(document.createTextNode(name));
        rootElement.appendChild(emId);
        rootElement.appendChild(emName);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(file));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }
}
