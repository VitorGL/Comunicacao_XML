import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();

        docBF.setNamespaceAware(false);

        DocumentBuilder docBuilder = docBF.newDocumentBuilder();

        Document xmlDoc = docBuilder.parse(new File("C:\\Users\\vitor\\IdeaProjects\\XML_treinamento\\src\\arquivo.xml"));


        Element root = xmlDoc.getDocumentElement(); // pega o

        Element hist = xmlDoc.createElement("historico");
        Element periodo = xmlDoc.createElement("periodo");

        hist.appendChild(periodo);
        root.appendChild(hist);


        XMLSerializer serializer;
        serializer = new XMLSerializer(System.out, new OutputFormat(xmlDoc, "iso-8859-1", true));

        serializer.serialize(xmlDoc);

    }
}
