package org.miketar.exercises.business;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic implementation of {@link MarkupCalculatorBO}
 * 
 * @author mickaeltardy
 *
 */
public class MarkupCalculatorBOImpl implements MarkupCalculatorBO {

	/**
	 * Flat markup value
	 */
	protected final static double FLAT_MARKUP = 0.05;

	/**
	 * One Person markup value
	 */
	protected final static double PERSON_MARKUP = 0.012;

	/**
	 * Categories markups
	 */
	private static final Map<String, Double> categoriesMarkup;

	static {
		Map<String, Double> catsMarkup = new HashMap<String, Double>();
		catsMarkup.put("food", 0.13);
		catsMarkup.put("drugs", 0.075);
		catsMarkup.put("electronics", 0.02);
		categoriesMarkup = Collections.unmodifiableMap(catsMarkup);
	}

	/**
	 * Default markup calculator method calculates only variable markup
	 * 
	 * @param personnelCnt
	 *            number of people involved, integer
	 * @param category
	 *            category of the product, string
	 */
	public double calculateMarkup(int peopleCnt, String category) {
		double markup = 0.0;

		markup += this.peopleMarkup(peopleCnt);
		markup += this.categoryMarkup(category);

		return markup;
	}

	/**
	 * Get flat markup
	 * 
	 * @return double value of the flat markup
	 */
	protected double flatMarkup() {
		return FLAT_MARKUP;
	}

	/**
	 * Calculate markup introduced by the number of people involved
	 * 
	 * @param peopleCnt
	 * @return
	 */
	protected double peopleMarkup(int peopleCnt) {
		return peopleCnt * PERSON_MARKUP;
	}

	/**
	 * Calculate markup introduced by specific category
	 * 
	 * @param category
	 * @return
	 */
	protected double categoryMarkup(String category) {
		if (category != null && category.compareTo("") != 0) {
			if (categoriesMarkup.containsKey(category))
				return categoriesMarkup.get(category);
		}
		return 0;
	}

	/**
	 * Final cost calculator calculating the flat markup in the first place and
	 * than applying the vatiable markup
	 * 
	 * @param price
	 *            initial base price, double
	 * @param peopleCnt
	 *            number of people involved, integer
	 * @param category
	 *            category of the product, string
	 * @return
	 */
	public double calculateFinalCost(double basePrice, int peopleCnt, String category) {
		double price = ((1 + this.flatMarkup()) * basePrice) * (1 + this.calculateMarkup(peopleCnt, category));
		return price;
	}

}
