package currencyConverter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Converter {
	
	private static Map<String, Double> ratesMap = new Hashtable<>();
	private final static String FILE_NAME = "./eurofxref-daily.xml";
	private static boolean dataLoaded = false;
	
	public static void loadData() {
		XMLParser.loadData(FILE_NAME);
	}
	
	public static void loadData(String pathToFile) {
		XMLParser.loadData(pathToFile);
	}
	
	public static void setDataLoaded() {
		dataLoaded = true;
	}
	
	public static double getRate(String currency) throws Error {
		if(!dataLoaded || !ratesMap.containsKey(currency)) 
			throw new Error("lack of data");
		return ratesMap.get(currency).doubleValue();
	}
	
	public static double validateInput(String currency, double euroValue) throws Error {
		if(currency == null) 
			throw new Error("currency is null");
		if(euroValue < 0)
			throw new Error("wrong input data");
		if(euroValue > 1000000000)
			throw new Error("too big number");
		return euroValue;
	}
	
	public static double validateInput(String currency, String euroValue) throws Error {
		if(euroValue == null) 
			throw new Error("currency is null");
		double euroValueDouble = -1;
		try {
			euroValueDouble = Double.parseDouble(euroValue);
	    } catch (NumberFormatException e) {
	    	throw new Error("value input is not correct");
	    }
		return validateInput(currency, euroValueDouble);
	}
	
	public static double round(double value) {
		return (double) Math.round(value * 100) / 100;
	}
	
	public static double roundDown(double value) {
		return (double) Math.floor(value * 100) / 100;
	}
	
	public static double convertRound(String currency, double euroValue) throws Error {
		validateInput(currency,euroValue);
		double rate = getRate(currency);
		double result = rate * euroValue;
		result = round(result);
		return result;
	}
	
	public static double convertFloor(String currency, double euroValue) throws Error {
		validateInput(currency,euroValue);
		double rate = getRate(currency);
		double result = rate * euroValue;
		result = roundDown(result);
		return result;
	}
	
	public static String convertRound(String currency, String euroValue) {
		double value = validateInput(currency,euroValue);
		return String.valueOf( convertRound(currency, value) );
	}
	
	public static void setValue(String currency, Double value) {
		ratesMap.put(currency, value);
	}
	
	public static Double getValue(String currency) {
		return ratesMap.get(currency);
	}
	
	public static ArrayList<String> getAvaiableCurrencies() {
		return new ArrayList<String>(ratesMap.keySet());
	}
	
}