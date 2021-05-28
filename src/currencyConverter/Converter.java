package currencyConverter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Converter {
	
	private static Map<String, Double> ratesMap = new Hashtable<>();
	private final static String FILE_NAME = "./eurofxref-daily.xml";
	private static boolean dataLoaded = false;
	
	public static void loadData() {
		try {
			XMLParser.loadData(FILE_NAME);
			dataLoaded = true;
		} catch(Error e) {
			dataLoaded = false;
		} catch(Exception e) {
			dataLoaded = false;
		}
	}
	
	public static void loadData(String pathToFile) {
		try {
			XMLParser.loadData(pathToFile);
			dataLoaded = true;
		} catch(Error e) {
			dataLoaded = false;
		} catch(Exception e) {
			dataLoaded = false;
		}
	}
	
	public static double getRate(String currency) {
		return ratesMap.get(currency).doubleValue();
	}
	
	public static double validateInput(String currency, double euroValue) throws Exception {
		if(currency == null) 
			throw new Exception("currency is null");
		if(euroValue < 0)
			throw new Exception("wrong input data");
		if(euroValue > 1000000000)
			throw new Exception("too big number");
		if(!dataLoaded || !ratesMap.containsKey(currency)) 
			throw new Exception("lack of data");
		return euroValue;
	}
	
	public static double validateInput(String currency, String euroValue) throws Exception {
		if(euroValue == null) 
			throw new Exception("value is null");
		double euroValueDouble = -1;
		try {
			euroValueDouble = Double.parseDouble(euroValue);
	    } catch (Exception e) {
	    	throw new Exception("parse exception");
	    }
		return validateInput(currency, euroValueDouble);
	}
	
	public static double round(double value) {
		return (double) Math.round(value * 100) / 100;
	}
	
	public static double roundFloor(double value) {
		return (double) Math.floor(value * 100) / 100;
	}
	
	public static double convert(String currency, double euroValue) throws Exception {
		validateInput(currency,euroValue);
		double rate = getRate(currency);
		double result = rate * euroValue;
		return result;
	}
	
	public static double convertRound(String currency, double euroValue) throws Exception {
		double result = round(convert(currency, euroValue));
		return result;
	}
	
	public static double convertFloor(String currency, double euroValue) throws Exception {
		double result = roundFloor(convert(currency, euroValue));
		return result;
	}
	
	public static String convertRound(String currency, String euroValue) throws Exception  {
		double value = validateInput(currency,euroValue);
		return String.valueOf( convertRound(currency, value) );
	}
	
	public static void setValue(String currency, Double value) {
		ratesMap.put(currency, value);
	}
	
	public static Double getValue(String currency) {
		return ratesMap.get(currency);
	}
	
	public static List<String> getAvaiableCurrencies() {
		return new ArrayList<String>(ratesMap.keySet());
	}
	
}