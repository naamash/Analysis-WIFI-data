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
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		int realsize = 1;

		assertTrue(46.0 == Formulas.sumOfAlt(a, realsize));

	}

	@Test
	public void testSumOfLat() {
		MacBig[] a = new MacBig[1];
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		int realsize = 1;

		assertTrue(32.10551925 == Formulas.sumOfLat(a, realsize));
	}

	@Test
	public void testSumOfLon() {
		MacBig[] a = new MacBig[1];
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		int realsize = 1;

		assertTrue(35.21240758 == Formulas.sumOfLon(a, realsize));
	}

	@Test
	public void testSumOfWeight() {
		MacBig[] a = new MacBig[1];
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		int realsize = 1;

		assertTrue(-46.0 == Formulas.sumOfWeight(a, realsize));

	}

	@Test
	public void testCalculatePI() {
		int inputSignal=2;
		int signalOfUs=3;
		double PI=0.47;

		assertTrue(1175.0 == Formulas.CalculatePI(inputSignal, signalOfUs, PI));
	}
}
