package Kuba;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //parsing nbp.xml

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("nbp.xml");

        NodeList nazwyWaluty = doc.getElementsByTagName("nazwa_waluty");
        NodeList kodyWaluty = doc.getElementsByTagName("kod_waluty");
        NodeList kursWaluty = doc.getElementsByTagName("kurs_sredni");

        String dataPublikacji = doc.getElementsByTagName("data_publikacji").item(0).getTextContent();

        System.out.println(dataPublikacji);

        //creating an array of objects

        CurrencyDetails [] currencies = new CurrencyDetails[nazwyWaluty.getLength()];

        for (int i = 0; i < nazwyWaluty.getLength(); i++) {

            Node node = nazwyWaluty.item(i);
            Node node1 = kodyWaluty.item(i);
            Node node2 = kursWaluty.item(i);

        //converting String to double

            String originalKurs = node2.getTextContent().replace(',', '.');
            double kurs = Double.parseDouble(originalKurs);

            currencies[i]= new CurrencyDetails(node.getTextContent(),node1.getTextContent(),kurs);

        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Waluta: ");
        String waluta = scanner.nextLine();

        for (int i = 0; i < currencies.length ; i++) {

           if (currencies[i].getNazwa().equals(waluta)){
               System.out.println("Kurs: " + currencies[i].getKurs());
           }

           //System.out.println(currencies[i].getNazwa() + " " + currencies[i].getKod() + " " + currencies[i].getKurs());
        }
    }
}




