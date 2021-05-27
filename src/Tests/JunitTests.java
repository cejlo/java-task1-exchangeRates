package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import currencyConverter.Converter;

public class JunitTests {
	
	public String currency1 = "PLN";
	public double rate1 = 4.4971;
	
	@Before
	public void setUp() {
		Converter.loadData();
	}
	
	@Test
	public void testGetRateWithError() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.getRate("XYZ");
		});
	}
	
	@Test
	public void testGetRate() {
		assertEquals(rate1, Converter.getRate(currency1), 0.0);
	}
	
	@Test
	public void testValidateInputError1() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.validateInput("PLN",-1.23);
		});
	}
	
	@Test
	public void testValidateInput2() {
		assertEquals(1.23, Converter.validateInput("",1.23), 0.0);
	}
	
	@Test
	public void testValidateInput3() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.validateInput("","");
		});
	}
	
	@Test
	public void testValidateInput() {
		assertEquals(1.23, Converter.validateInput("PLN",1.23),0.0);
	}
	
	@Test
	public void testRound() {
		assertEquals(1.23, Converter.round(1.231), 0.0);
		assertEquals(1.24, Converter.round(1.235), 0.0);
		assertEquals(1.24, Converter.round(1.238), 0.0);
	}
	
	@Test
	public void testroundDown() {
		assertEquals(1.23, Converter.roundDown(1.231), 0.0);
		assertEquals(1.23, Converter.roundDown(1.235), 0.0);
		assertEquals(1.23, Converter.roundDown(1.238), 0.0);
	}
	
	@Test
	public void testConvertRound() {
		// 23.519833
		assertEquals(23.52, Converter.convertRound("PLN", 5.23), 0.0);
		// 6.395767
		assertEquals(6.40, Converter.convertRound("USD", 5.23), 0.0);
		// 4.515059
		assertEquals(4.52, Converter.convertRound("GBP", 5.23), 0.0);
	}
	
	@Test
	public void testConvertFloor() {
		// 23.519833
		assertEquals(23.51, Converter.convertFloor("PLN", 5.23), 0.0);
		// 6.395767
		assertEquals(6.39, Converter.convertFloor("USD", 5.23), 0.0);
		// 4.515059
		assertEquals(4.51, Converter.convertFloor("GBP", 5.23), 0.0);
	}
	
	@Test
	public void testConvertRoundError() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertRound("PLN", -5.23);
		});
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertRound("XYZ", 5.23);
		});
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertRound("XYZ", -5.23);
		});
	}
	
	@Test
	public void testConvertFloorError() {
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertFloor("PLN", -5.23);
		});
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertFloor("XYZ", 5.23);
		});
		Assertions.assertThrows(Error.class, () -> {
			Converter.convertFloor("XYZ", -5.23);
		});
	}
	
}