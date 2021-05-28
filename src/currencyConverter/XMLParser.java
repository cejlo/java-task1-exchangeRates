package currencyConverter;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {

	public static void loadData(String fileName) throws Error, Exception {
		File inputFile = new File(fileName);
	    SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser saxParser = factory.newSAXParser();
	    RatesHandler userhandler = new RatesHandler();
	    saxParser.parse(inputFile, userhandler);
	}
	
}