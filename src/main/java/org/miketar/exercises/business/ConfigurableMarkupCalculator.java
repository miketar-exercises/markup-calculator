package org.miketar.exercises.business;

import java.io.InputStream;
import java.util.Properties;

/**
 * Configurable markup calculator using properties specified in
 * {@value ConfigurableMarkupCalculator#MARKUP_CONFIGFILE} configuration file
 * 
 * This calculator bases on the {@link MarkupCalculatorBOImpl} way of
 * calculating the markup
 * 
 * @author mickaeltardy
 *
 */
public class ConfigurableMarkupCalculator extends MarkupCalculatorBOImpl {

	protected static final String CATEGORIES_SEPARATOR = ";";
	protected static final String KEYVALUE_SEPARATOR = ":";
	protected static final double DEFAULT_MARKUP = 0.0;
	protected static final String MARKUP_CONFIGFILE = "/markup.properties";

	Properties properties = null;

	@Override
	protected double flatMarkup() {
		return readDoubleProperty(MarkupConstants.Properties.FLAT, DEFAULT_MARKUP);
	}

	@Override
	protected double peopleMarkup(int peopleCnt) {
		return readDoubleProperty(MarkupConstants.Properties.PERSON, DEFAULT_MARKUP) * peopleCnt;
	}

	@Override
	protected double categoryMarkup(String category) {
		double markup = 0.0;
		String categoriesMarkup = this.readProperty(MarkupConstants.Properties.CATEGORIES, "");

		String[] categories = categoriesMarkup.split(CATEGORIES_SEPARATOR);
		if (categories != null && categories.length > 0) {
			for (String categoryMarkup : categories) {
				String[] keyValuePair = categoryMarkup.split(KEYVALUE_SEPARATOR);
				if (keyValuePair != null && keyValuePair.length == 2 && keyValuePair[0].compareTo(category) == 0)
					markup = Double.parseDouble(keyValuePair[1]);
			}
		}

		return markup;
	}

	/**
	 * Try to read the double property from the properties file
	 * 
	 * @param label
	 *            read property label
	 * @param defaultValue
	 *            default double value of the property
	 * @return property value converted in double or default if reading fails
	 */
	protected double readDoubleProperty(String label, double defaultValue) {
		String markup = this.readProperty(label, Double.toString(defaultValue));
		if (Utils.isNotEmpty(markup)) {
			return Double.parseDouble(markup);
		}
		return defaultValue;
	}

	/**
	 * Try to read the property from the properties file
	 * 
	 * @param label
	 *            read property label
	 * @param defaultValue
	 *            default value of the property
	 * @return property value or default if reading fails
	 */
	protected String readProperty(String label, String defaultVaule) {
		if (Utils.isNotEmpty(label)) {
			if (properties == null)
				loadProperties();

			if (properties != null) {
				return properties.getProperty(generateFullPropertyLabel(label), defaultVaule);
			}
		}

		return defaultVaule;

	}

	/**
	 * Generate full property label by adding prefix
	 * 
	 * @param label
	 *            property label
	 * @return property label with prefix
	 * 
	 */
	protected String generateFullPropertyLabel(String label) {
		if (Utils.isNotEmpty(label)) {
			return MarkupConstants.Properties.PREFIX + label;
		}
		return label;
	}

	/**
	 * Load properties from configuration file
	 * 
	 * Read only if not read previously
	 * 
	 * @return full properties object
	 */
	protected Properties loadProperties() {

		if (properties == null) {
			Properties props = new Properties();
			InputStream input = null;
			String filename = MARKUP_CONFIGFILE;
			input = this.getClass().getResourceAsStream(filename);
			try {
				props.load(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
			properties = props;
		}

		return properties;
	}

}
