package org.miketar.exercises.business;

/**
 * Basic implementation of {@link MarkupCalculatorBO}
 * 
 * @author mickaeltardy
 *
 */
public class MarkupCalculatorBOImpl implements MarkupCalculatorBO {

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
		return MarkupConstants.FLAT_MARKUP;
	}

	/**
	 * Calculate markup introduced by the number of people involved
	 * 
	 * @param peopleCnt
	 * @return
	 */
	protected double peopleMarkup(int peopleCnt) {
		return peopleCnt * MarkupConstants.PERSON_MARKUP;
	}

	/**
	 * Calculate markup introduced by specific category
	 * 
	 * @param category
	 * @return
	 */
	protected double categoryMarkup(String category) {
		if (category != null && category.compareTo("") != 0) {
			if (MarkupConstants.CATEGORIES_MARKUP.containsKey(category))
				return MarkupConstants.CATEGORIES_MARKUP.get(category);
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
