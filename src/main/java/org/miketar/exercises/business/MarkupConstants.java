package org.miketar.exercises.business;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MarkupConstants {

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
	protected static final Map<String, Double> CATEGORIES_MARKUP;

	static {
		Map<String, Double> catsMarkup = new HashMap<String, Double>();
		catsMarkup.put("food", 0.13);
		catsMarkup.put("drugs", 0.075);
		catsMarkup.put("electronics", 0.02);
		CATEGORIES_MARKUP = Collections.unmodifiableMap(catsMarkup);
	}
	
	protected class Properties {
		public final static String CATEGORIES = "categories";
		public final static String FLAT = "flat";
		public final static String PERSON = "person";
		public final static String PREFIX = "markup.";
	}

}
