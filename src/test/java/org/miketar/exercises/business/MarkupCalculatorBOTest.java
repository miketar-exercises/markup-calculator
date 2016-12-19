package org.miketar.exercises.business;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class MarkupCalculatorBOTest {

	protected abstract MarkupCalculatorBO getMarkupCalculator();

	/**
	 * Test validating final cost calculation
	 * 
	 * @param basePrice
	 *            base price
	 * @param peopleCnt
	 *            number of people involved
	 * @param category
	 *            category of the product
	 * @param expectedFinalCost
	 *            expected result
	 */
	@Test(dataProvider = "finalCostCalculationData")
	public void testFinalCostCalculation(double basePrice, int peopleCnt, String category, double expectedFinalCost) {
		double finalCost = getMarkupCalculator().calculateFinalCost(basePrice, peopleCnt, category);
		double roundedCost = Math.round(finalCost * 100.0) / 100.0;
		Assert.assertEquals(roundedCost, expectedFinalCost);
	}

	/**
	 * Test cases validating the markup calculator business
	 * 
	 * Example 1: ---------- Input: $1,299.99, 3 people, food Output: $1,591.58
	 * 
	 * Example 2: ---------- Input: $5,432.00, 1 person, drugs Output: $6,199.81
	 * 
	 * Example 3: ---------- Input: $12,456.95, 4 people, books Output:
	 * $13,707.63
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] finalCostCalculationData() {
		return new Object[][] { { 1299.99, 3, "food", 1591.58 }, { 5432.00, 1, "drugs", 6199.81 },
				{ 12456.95, 4, "books", 13707.63 } };
	}

}
