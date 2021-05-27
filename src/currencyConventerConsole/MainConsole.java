package currencyConventerConsole;

import currencyConverter.Converter;

public class MainConsole {

	public static void start() {
		Converter.loadData();
	}
	
	public static void main(String[] args) {
		start();
		if(args[0] != null && args[1] != null) {
			String result = Converter.convertRound(args[0],args[1]);
			System.out.println(result);
		}
		
	}
	
}