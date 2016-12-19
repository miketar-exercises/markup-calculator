package org.miketar.exercises.business;

public class ConfigurableMarkupCalculatorTest extends MarkupCalculatorBOTest {

	@Override
	protected MarkupCalculatorBO getMarkupCalculator() {
		return new ConfigurableMarkupCalculator();
	}

}
