package Tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import currencyConverter.Converter;

public class JunitTestsLoad {
	
	@Test
	public void testLoadError() {
		Assertions.assertThrows(Exception.class, () -> {
			Converter.convertRound("PLN",2.50);
		});
	}
}
