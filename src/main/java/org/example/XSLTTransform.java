package org.example;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTTransform {

    public void transformXML() {
        try {
            String xmlFile = "D:\\java_projects\\lab9\\bip.poznan.pl.xml";
            String xsltFile = "D:\\java_projects\\lab9\\src\\main\\java\\org\\example\\teamplate.xslt";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            builder.parse(new File(xmlFile));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File(xsltFile));

            Transformer transformer = transformerFactory.newTransformer(xslt);

            Source xmlSource = new StreamSource(new File(xmlFile));

            StreamResult output = new StreamResult(new File("output.html"));

            transformer.transform(xmlSource, output);

            System.out.println("Transformacja zakończona sukcesem!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


