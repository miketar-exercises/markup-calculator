package org.miketar.exercises.business;

/**
 * Test cases validating the {@link MarkupCalculatorBOImpl} business
 * 
 * @author mickaeltardy
 *
 */
public class MarkupCalculatorBOImplTest extends MarkupCalculatorBOTest {

	protected MarkupCalculatorBO getMarkupCalculator(){
		return new ConfigurableMarkupCalculator();
	}
	
}
