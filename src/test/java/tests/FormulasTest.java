package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import algo1and2.Formulas;
import objects.MacBig;

public class FormulasTest {


	@Test
	public void testWeight() {
		int signal = 2;
		assertTrue(0.25 == Formulas.weight(signal));
	}

	@Test
	public void testWalt() {
		double weight = 1.5;
		double value = 2.0;
		assertTrue(3.0 == Formulas.walt(weight, value));

	}

	@Test
	public void testSumOfAlt() {
		MacBig[] a = new MacBig[1];
		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		a[0]=av;
		int realsize = 1;

		assertTrue(7.777438959 == Formulas.sumOfAlt(a, realsize));

	}

	@Test
	public void testSumOfLat() {
		MacBig[] a = new MacBig[1];
		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		a[0]=av;
		int realsize = 1;

		assertTrue(32.17224246 == Formulas.sumOfLat(a, realsize));
	}

	@Test
	public void testSumOfLon() {
		MacBig[] a = new MacBig[1];
		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		a[0]=av;
		int realsize = 1;

		assertTrue(34.81444894 == Formulas.sumOfLon(a, realsize));
	}

	@Test
	public void testSumOfWeight() {
		MacBig[] a = new MacBig[1];
		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		a[0]=av;
		int realsize = 1;

		assertTrue(-92.0 == Formulas.sumOfWeight(a, realsize));

	}

	@Test
	public void testCalculatePI() {
		int inputSignal=2;
		int signalOfUs=3;
		double PI=0.47;

		assertTrue(1175.0 == Formulas.CalculatePI(inputSignal, signalOfUs, PI));
	}
}