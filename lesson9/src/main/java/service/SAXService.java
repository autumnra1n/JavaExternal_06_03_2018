package service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import validation.errorhandler.ErrorHandler;

import java.io.IOException;

public class SAXService implements Service {

    public class SimpleHandler extends DefaultHandler{
        public void startDocument() {
            System.out.println("Parsing started");
        }
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attrs) {
            StringBuilder s = new StringBuilder(localName);
            for (int i = 0; i < attrs.getLength(); i++) {
                s.append(" ").append(attrs.getLocalName(i)).append("=").append(attrs.getValue(i));
            }
            System.out.print(s.toString().trim());
        }
        @Override
        public void characters(char[ ] ch, int start, int length) {
            System.out.print(new String(ch, start, length));
        }
        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.print(localName);
        }
        @Override
        public void endDocument() {
            System.out.println("\nParsing ended");
        }
    }

    public void parseDocument(String path){
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleHandler handler = new SimpleHandler();
            reader.setContentHandler(handler);
            reader.parse(path);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}
