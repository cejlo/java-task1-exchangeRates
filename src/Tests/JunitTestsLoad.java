package Tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import currencyConverter.Converter;

public class JunitTestsLoad {
	
	@Test
	public void testGetRateError() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.getRate("PLN");
		});
	}
	
	@Test
	public void testLoadError() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.loadData("fakeFileName.xml");
		});
	}
}
