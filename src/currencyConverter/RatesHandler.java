package currencyConverter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RatesHandler extends DefaultHandler {
	
	public void startElement (
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
      		
      if (qName.equalsIgnoreCase("Cube")) {
    	  if (attributes.getValue("currency") != null) {
	    	   String currency = attributes.getValue("currency");
	    	   String rate = attributes.getValue("rate");
	    	   Double rateDouble = Double.parseDouble(rate);
	    	   Converter.setValue(currency, rateDouble);
    	  }
      }
   }

}
