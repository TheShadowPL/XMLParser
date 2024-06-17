package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import org.example.XMLStructure.BipPoznanPlType;
import org.example.XMLStructure.DataType;
import org.example.XMLStructure.KartaInformacyjnaType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Unmarshaller;

import org.example.XSLTTransform;

public class Main {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public Main() {
        frame = new JFrame("XML Parser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        JButton jaxpButton = new JButton("Metoda JAXP DOM");
        JButton jaxp2Button = new JButton("Metoda JAXP SAX");
        JButton jaxbButton = new JButton("Metoda JAXB");
        JButton clrbButton = new JButton("Wyczysc");
        JButton xsltButton = new JButton("Załaduj HTML");

        String[] columnNames = {"Nazwa", "Ulica", "Miejscowość"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(jaxpButton);
        panel.add(jaxp2Button);
        panel.add(jaxbButton);
        panel.add(clrbButton);
        panel.add(xsltButton);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        jaxpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                parseXMLWithJAXP("bip.poznan.pl.xml");
            }
        });

        jaxp2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                parseXMLWithJAXPSAX("bip.poznan.pl.xml");
            }
        });

        jaxbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                try {
                    parseXMLWithJAXB("bip.poznan.pl.xml");
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }
        });

        clrbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
            }
        });


        xsltButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XSLTTransform xsltTransform = new XSLTTransform();
                xsltTransform.transformXML();
                openHTMLFile("D:\\java_projects\\lab9\\output.html");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    public void parseXMLWithJAXP(String filePath) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("dane_wnioskodawcy");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String daneWnioskodawcy = element.getTextContent();
                    String[] parts = daneWnioskodawcy.split(", ");
                    if (parts.length == 3) {
                        String[] rowData = {parts[0], parts[1], parts[2]};
                        tableModel.addRow(rowData);
                    } else {
                        System.err.println("Nieprawidłowy format danych: " + daneWnioskodawcy);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseXMLWithJAXPSAX(String filePath) {
        try {
            File file = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean isDaneWnioskodawcy = false;
                StringBuilder currentValue = new StringBuilder();

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("dane_wnioskodawcy")) {
                        isDaneWnioskodawcy = true;
                        currentValue.setLength(0);
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (isDaneWnioskodawcy) {
                        currentValue.append(new String(ch, start, length));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("dane_wnioskodawcy")) {
                        isDaneWnioskodawcy = false;
                        String daneWnioskodawcy = currentValue.toString().trim();
                        String[] parts = daneWnioskodawcy.split(", ");
                        if (parts.length == 3) {
                            String[] rowData = {parts[0], parts[1], parts[2]};
                            tableModel.addRow(rowData);
                        } else {
                            System.err.println("Nieprawidłowy format danych: " + daneWnioskodawcy);
                        }
                    }
                }
            };

            parser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    public static void parseXMLWithJAXPSAX(String filePath) {
        try {
            File file = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean isDaneWnioskodawcy = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("dane_wnioskodawcy")) {
                        isDaneWnioskodawcy = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (isDaneWnioskodawcy) {
                        String daneWnioskodawcy = new String(ch, start, length);
                        System.out.println("Dane: " + daneWnioskodawcy + '\n');
                        isDaneWnioskodawcy = false;
                    }
                }
            };

            parser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */


    public void parseXMLWithJAXB(String filePath) throws JAXBException {

        File xmlFile = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(BipPoznanPlType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<BipPoznanPlType> jaxbElement = unmarshaller.unmarshal(new StreamSource(xmlFile), BipPoznanPlType.class);
        BipPoznanPlType bipPoznanPl = jaxbElement.getValue();

        DataType data = bipPoznanPl.getData();
        if (data != null && data.getKartyInformacyjne() != null && data.getKartyInformacyjne().getItems() != null) {
            for (KartaInformacyjnaType karta : data.getKartyInformacyjne().getItems().getKartaInformacyjna()) {
                String daneWnioskodawcy = karta.getDaneWnioskodawcy();
                String[] parts = daneWnioskodawcy.split(", ");
                if (parts.length == 3) {
                    String[] rowData = {parts[0], parts[1], parts[2]};
                    tableModel.addRow(rowData);
                } else {
                    System.err.println("Nieprawidłowy format danych: " + daneWnioskodawcy);
                }
            }
        } else {
            System.err.println("Brak danych kartyInformacyjne");
        }
    }

    private void openHTMLFile(String filePath) {
        try {
            File htmlFile = new File(filePath);
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                JOptionPane.showMessageDialog(frame, "Plik nie istnieje: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
