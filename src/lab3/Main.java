package lab3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder documentBuilder = factory.newDocumentBuilder();
	  Document doc = documentBuilder.parse(new File("src/file.xml"));

	  String titleEl = doc.getDocumentElement().getNodeName();
	  System.out.println("titleEl = " + titleEl);

	  NodeList nodeList = doc.getElementsByTagName("material");
	  String type, ExternalWork, InternalWork  = "";
	  int price = 0;
			int  number = 0;
		String country = "";
				String firm = "";
		int material, currency = 0;

		System.out.println("number" + "     " +  "type" + "         " + "country" + "      " + "firm" + "       "+ "ExternalWork" +   "       " + "InternalWork" + "       "  +  "price"  );

		for(int i=0; i < nodeList.getLength(); i++) {

	  	Element element = (Element) nodeList.item(i);
          type = element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
			firm = element.getElementsByTagName("firm").item(0).getChildNodes().item(0).getNodeValue();
			ExternalWork = element.getElementsByTagName("ExternalWork").item(0).getChildNodes().item(0).getNodeValue();
			InternalWork = element.getElementsByTagName("InternalWork").item(0).getChildNodes().item(0).getNodeValue();

          country = element.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue();
		  price = Integer.parseInt(element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());
		  material = Integer.parseInt((element.getAttributes().getNamedItem("id").getNodeValue()));
			//currency = Integer.parseInt((element.getAttributes().getNamedItem("currency").getNodeValue()));


		  System.out.println(material + "          " +  type + "        " + country + "      " + firm + "           "+ ExternalWork +   "               " + InternalWork + "              "  +  price + "    "  );

	  		  }

    }
}
