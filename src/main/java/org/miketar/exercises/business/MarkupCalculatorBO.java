package org.miketar.exercises.business;

/**
 * Markup calculator is responsible of calculating the markup according to the
 * specified rules as well as calculating of the final cost of the project
 * 
 * @author mickaeltardy
 *
 */
public interface MarkupCalculatorBO {

	/**
	 * Calculate the markup based on the number of people involved in the job
	 * and category of the product
	 * 
	 * @param personnelCnt
	 *            number of people involved, integer
	 * @param category
	 *            category of the product, string
	 * @return
	 */
	public double calculateMarkup(int peopleCnt, String category);

	/**
	 * Calculate the final cost of the project using the initial price and based
	 * on the number of personal involved and category of the product
	 * 
	 * @param price
	 *            initial base price, double
	 * @param peopleCnt
	 *            number of people involved, integer
	 * @param category
	 *            category of the product, string
	 * @return
	 */
	public double calculateFinalCost(double basePrice, int peopleCnt, String category);

}
