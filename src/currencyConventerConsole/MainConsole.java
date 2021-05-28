package currencyConventerConsole;

import currencyConverter.Converter;

public class MainConsole {

	public static void start() {
		Converter.loadData();
	}
	
	public static void main(String[] args) {
		start();
		if(args[0] != null && args[1] != null) {
			String result = "-1";
			try {
				result = Converter.convertRound(args[0],args[1]);
			} catch (Exception e) {
				System.out.println("Wrong data, please correct the values");
			}
			System.out.println(result);
		}
	}
	
}